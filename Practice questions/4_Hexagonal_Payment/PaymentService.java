// Payment Service - Core Business Logic (Hexagon)
// Independent of external systems - uses Ports (interfaces)
public class PaymentService {
    private final PaymentGatewayPort paymentGateway;
    private final PaymentRepositoryPort paymentRepository;
    
    // Dependency Inversion - depends on abstractions, not concretions
    public PaymentService(PaymentGatewayPort paymentGateway, PaymentRepositoryPort paymentRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
    }
    
    // Core business logic - knows nothing about Stripe, PayPal, or database
    public PaymentResult processOrder(String orderId, double amount, String currency, String email) {
        System.out.println("\n=== Processing Order: " + orderId + " ===");
        System.out.println("Amount: " + amount + " " + currency);
        System.out.println("Customer: " + email);
        System.out.println("Gateway: " + paymentGateway.getGatewayName());
        System.out.println();
        
        // Validate business rules
        if (amount <= 0) {
            return new PaymentResult(false, null, "Invalid amount");
        }
        
        if (amount > 10000) {
            System.out.println("[BUSINESS RULE] Large transaction - additional verification required");
        }
        
        // Create payment request
        PaymentRequest request = new PaymentRequest(orderId, amount, currency, email);
        
        // Process payment through gateway (via Port)
        PaymentResult result = paymentGateway.processPayment(request);
        
        // Save payment record (via Port)
        if (result.isSuccess()) {
            paymentRepository.savePayment(result.getTransactionId(), request, result);
        }
        
        System.out.println("\nResult: " + result);
        return result;
    }
    
    public PaymentResult refundOrder(String transactionId, double amount) {
        System.out.println("\n=== Processing Refund ===");
        System.out.println("Transaction: " + transactionId);
        System.out.println("Refund Amount: " + amount);
        System.out.println();
        
        // Business rule: Check if payment exists
        PaymentResult originalPayment = paymentRepository.findPaymentByTransactionId(transactionId);
        if (originalPayment == null) {
            return new PaymentResult(false, null, "Original payment not found");
        }
        
        // Process refund through gateway
        PaymentResult refundResult = paymentGateway.refundPayment(transactionId, amount);
        
        // Update payment status
        if (refundResult.isSuccess()) {
            paymentRepository.updatePaymentStatus(transactionId, "REFUNDED");
        }
        
        System.out.println("\nResult: " + refundResult);
        return refundResult;
    }
}

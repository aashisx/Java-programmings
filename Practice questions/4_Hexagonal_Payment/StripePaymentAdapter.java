import java.util.UUID;

// Stripe Payment Gateway Adapter - Implements PaymentGatewayPort
public class StripePaymentAdapter implements PaymentGatewayPort {
    
    @Override
    public PaymentResult processPayment(PaymentRequest request) {
        System.out.println("[STRIPE] Processing payment...");
        System.out.println("[STRIPE] Connecting to Stripe API...");
        System.out.println("[STRIPE] Validating card details...");
        
        // Simulate Stripe API call
        String transactionId = "STRIPE_" + UUID.randomUUID().toString().substring(0, 8);
        
        System.out.println("[STRIPE] Payment authorized!");
        return new PaymentResult(true, transactionId, "Payment successful via Stripe");
    }
    
    @Override
    public PaymentResult refundPayment(String transactionId, double amount) {
        System.out.println("[STRIPE] Processing refund for: " + transactionId);
        System.out.println("[STRIPE] Refund amount: $" + amount);
        
        String refundId = "STRIPE_REF_" + UUID.randomUUID().toString().substring(0, 8);
        return new PaymentResult(true, refundId, "Refund processed via Stripe");
    }
    
    @Override
    public String getGatewayName() {
        return "Stripe";
    }
}

import java.util.UUID;

// PayPal Payment Gateway Adapter - Implements PaymentGatewayPort
public class PayPalPaymentAdapter implements PaymentGatewayPort {
    
    @Override
    public PaymentResult processPayment(PaymentRequest request) {
        System.out.println("[PAYPAL] Processing payment...");
        System.out.println("[PAYPAL] Connecting to PayPal REST API...");
        System.out.println("[PAYPAL] Authenticating merchant account...");
        System.out.println("[PAYPAL] Creating payment order...");
        
        // Simulate PayPal API call
        String transactionId = "PAYPAL_" + UUID.randomUUID().toString().substring(0, 8);
        
        System.out.println("[PAYPAL] Payment captured!");
        return new PaymentResult(true, transactionId, "Payment successful via PayPal");
    }
    
    @Override
    public PaymentResult refundPayment(String transactionId, double amount) {
        System.out.println("[PAYPAL] Processing refund for: " + transactionId);
        System.out.println("[PAYPAL] Initiating refund via PayPal API...");
        
        String refundId = "PAYPAL_REF_" + UUID.randomUUID().toString().substring(0, 8);
        return new PaymentResult(true, refundId, "Refund processed via PayPal");
    }
    
    @Override
    public String getGatewayName() {
        return "PayPal";
    }
}

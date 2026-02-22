// Payment Gateway Port (Interface) - Outbound Port
// Core business logic depends on this interface, not concrete implementations
public interface PaymentGatewayPort {
    PaymentResult processPayment(PaymentRequest request);
    PaymentResult refundPayment(String transactionId, double amount);
    String getGatewayName();
}

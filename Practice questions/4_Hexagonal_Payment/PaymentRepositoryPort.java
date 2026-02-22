// Payment Repository Port (Interface) - Outbound Port for persistence
public interface PaymentRepositoryPort {
    void savePayment(String transactionId, PaymentRequest request, PaymentResult result);
    PaymentResult findPaymentByTransactionId(String transactionId);
    void updatePaymentStatus(String transactionId, String status);
}

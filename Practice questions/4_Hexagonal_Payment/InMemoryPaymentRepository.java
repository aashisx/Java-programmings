import java.util.HashMap;
import java.util.Map;

// In-Memory Payment Repository Adapter - Implements PaymentRepositoryPort
public class InMemoryPaymentRepository implements PaymentRepositoryPort {
    private final Map<String, PaymentRecord> payments = new HashMap<>();
    
    private static class PaymentRecord {
        PaymentRequest request;
        PaymentResult result;
        String status;
        
        PaymentRecord(PaymentRequest request, PaymentResult result) {
            this.request = request;
            this.result = result;
            this.status = "COMPLETED";
        }
    }
    
    @Override
    public void savePayment(String transactionId, PaymentRequest request, PaymentResult result) {
        payments.put(transactionId, new PaymentRecord(request, result));
        System.out.println("[DB] Payment saved: " + transactionId);
    }
    
    @Override
    public PaymentResult findPaymentByTransactionId(String transactionId) {
        PaymentRecord record = payments.get(transactionId);
        if (record != null) {
            return record.result;
        }
        return null;
    }
    
    @Override
    public void updatePaymentStatus(String transactionId, String status) {
        PaymentRecord record = payments.get(transactionId);
        if (record != null) {
            record.status = status;
            System.out.println("[DB] Payment status updated: " + transactionId + " -> " + status);
        }
    }
}

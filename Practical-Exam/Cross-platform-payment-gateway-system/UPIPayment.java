// Interface for UPI Payment
public interface UPIPayment {
    void processPayment(double amount, String upiId);
    void validateUPI(String upiId);
}

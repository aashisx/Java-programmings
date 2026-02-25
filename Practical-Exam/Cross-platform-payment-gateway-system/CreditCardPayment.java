
public interface CreditCardPayment {
    void processPayment(double amount, String cardNumber);
    void validateCard(String cardNumber);
}

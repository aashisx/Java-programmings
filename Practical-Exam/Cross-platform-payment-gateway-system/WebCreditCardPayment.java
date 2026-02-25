// Web platform Credit Card Payment implementation
public class WebCreditCardPayment implements CreditCardPayment {
    
    @Override
    public void processPayment(double amount, String cardNumber) {
        System.out.println("[WEB] Processing Credit Card payment...");
        System.out.println("[WEB] Using secure HTTPS gateway for card: " + maskCardNumber(cardNumber));
        System.out.println("[WEB] Amount: $" + amount + " processed via Web SSL/TLS channel");
        System.out.println("[WEB] Redirecting to bank 3D Secure page...");
        System.out.println("[WEB] Credit Card payment successful!\n");
    }
    
    @Override
    public void validateCard(String cardNumber) {
        System.out.println("[WEB] Validating card using Web Luhn algorithm check...");
        System.out.println("[WEB] Card " + maskCardNumber(cardNumber) + " is valid.\n");
    }
    
    private String maskCardNumber(String cardNumber) {
        if (cardNumber.length() >= 4) {
            return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
        }
        return "****";
    }
}


public class MobileCreditCardPayment implements CreditCardPayment {
    
    @Override
    public void processPayment(double amount, String cardNumber) {
        System.out.println("[MOBILE] Processing Credit Card payment...");
        System.out.println("[MOBILE] Using NFC/Card scanner for card: " + maskCardNumber(cardNumber));
        System.out.println("[MOBILE] Amount: $" + amount + " processed via Mobile SDK");
        System.out.println("[MOBILE] Biometric authentication requested...");
        System.out.println("[MOBILE] Push notification sent to device.");
        System.out.println("[MOBILE] Credit Card payment successful!\n");
    }
    
    @Override
    public void validateCard(String cardNumber) {
        System.out.println("[MOBILE] Validating card using Mobile camera OCR...");
        System.out.println("[MOBILE] Card " + maskCardNumber(cardNumber) + " is valid.\n");
    }
    
    private String maskCardNumber(String cardNumber) {
        if (cardNumber.length() >= 4) {
            return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
        }
        return "****";
    }
}

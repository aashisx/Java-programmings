public class MobileUPIPayment implements UPIPayment {
    
    @Override
    public void processPayment(double amount, String upiId) {
        System.out.println("[MOBILE] Processing UPI payment...");
        System.out.println("[MOBILE] Opening UPI app intent for: " + upiId);
        System.out.println("[MOBILE] Scanning QR code via camera...");
        System.out.println("[MOBILE] Amount: $" + amount + " processed via Mobile UPI SDK");
        System.out.println("[MOBILE] UPI PIN requested via secure keypad.");
        System.out.println("[MOBILE] UPI payment successful!\n");
    }
    
    @Override
    public void validateUPI(String upiId) {
        System.out.println("[MOBILE] Validating UPI ID via Mobile app...");
        if (upiId.contains("@")) {
            System.out.println("[MOBILE] UPI ID " + upiId + " is valid.\n");
        } else {
            System.out.println("[MOBILE] Invalid UPI ID format.\n");
        }
    }
}

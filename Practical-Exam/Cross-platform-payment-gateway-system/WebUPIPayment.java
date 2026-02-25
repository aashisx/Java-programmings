// Web platform UPI Payment implementation
public class WebUPIPayment implements UPIPayment {
    
    @Override
    public void processPayment(double amount, String upiId) {
        System.out.println("[WEB] Processing UPI payment...");
        System.out.println("[WEB] Initiating UPI collect request to: " + upiId);
        System.out.println("[WEB] Displaying QR code on browser...");
        System.out.println("[WEB] Amount: $" + amount + " processed via Web UPI gateway");
        System.out.println("[WEB] UPI payment successful!\n");
    }
    
    @Override
    public void validateUPI(String upiId) {
        System.out.println("[WEB] Validating UPI ID format via Web validator...");
        if (upiId.contains("@")) {
            System.out.println("[WEB] UPI ID " + upiId + " is valid.\n");
        } else {
            System.out.println("[WEB] Invalid UPI ID format.\n");
        }
    }
}

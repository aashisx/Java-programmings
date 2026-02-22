// Mobile Platform SMS Notification
public class MobileSMSNotification implements SMSNotification {
    @Override
    public void sendSMS(String phoneNumber, String message) {
        System.out.println("[MOBILE SMS]");
        System.out.println("  Phone: " + phoneNumber);
        System.out.println("  Message: " + message);
        System.out.println("  Sent via Native SMS Manager");
    }
}

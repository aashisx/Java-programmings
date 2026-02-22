// Web Platform SMS Notification
public class WebSMSNotification implements SMSNotification {
    @Override
    public void sendSMS(String phoneNumber, String message) {
        System.out.println("[WEB SMS]");
        System.out.println("  Phone: " + phoneNumber);
        System.out.println("  Message: " + message);
        System.out.println("  Sent via Web SMS API (Twilio)");
    }
}

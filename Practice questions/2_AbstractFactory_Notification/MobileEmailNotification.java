// Mobile Platform Email Notification
public class MobileEmailNotification implements EmailNotification {
    @Override
    public void sendEmail(String to, String subject, String body) {
        System.out.println("[MOBILE EMAIL]");
        System.out.println("  To: " + to);
        System.out.println("  Subject: " + subject);
        System.out.println("  Body: " + body);
        System.out.println("  Sent via Mobile Mail Client Intent");
    }
}

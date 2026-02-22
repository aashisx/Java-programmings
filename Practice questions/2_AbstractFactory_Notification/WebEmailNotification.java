// Web Platform Email Notification
public class WebEmailNotification implements EmailNotification {
    @Override
    public void sendEmail(String to, String subject, String body) {
        System.out.println("[WEB EMAIL]");
        System.out.println("  To: " + to);
        System.out.println("  Subject: " + subject);
        System.out.println("  Body: " + body);
        System.out.println("  Sent via Web SMTP Gateway");
    }
}

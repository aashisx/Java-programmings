// Notification Service - Client code independent of concrete classes
// Uses Dependency Injection for factory
public class NotificationService {
    private final NotificationFactory factory;
    
    // Dependency Injection via constructor
    public NotificationService(NotificationFactory factory) {
        this.factory = factory;
    }
    
    public void sendAllNotifications(String recipient, String phone, String deviceId, 
                                      String subject, String message) {
        System.out.println("\n=== Sending notifications via " + factory.getPlatformName() + " Platform ===\n");
        
        // Client code doesn't know about concrete implementations
        EmailNotification email = factory.createEmailNotification();
        email.sendEmail(recipient, subject, message);
        
        System.out.println();
        
        SMSNotification sms = factory.createSMSNotification();
        sms.sendSMS(phone, message);
        
        System.out.println();
        
        PushNotification push = factory.createPushNotification();
        push.sendPush(deviceId, subject, message);
    }
    
    public void sendEmail(String to, String subject, String body) {
        EmailNotification email = factory.createEmailNotification();
        email.sendEmail(to, subject, body);
    }
    
    public void sendSMS(String phone, String message) {
        SMSNotification sms = factory.createSMSNotification();
        sms.sendSMS(phone, message);
    }
    
    public void sendPush(String deviceId, String title, String message) {
        PushNotification push = factory.createPushNotification();
        push.sendPush(deviceId, title, message);
    }
}

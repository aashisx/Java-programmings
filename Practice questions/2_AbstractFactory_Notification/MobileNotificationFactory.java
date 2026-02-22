// Mobile Platform Notification Factory
public class MobileNotificationFactory implements NotificationFactory {
    @Override
    public EmailNotification createEmailNotification() {
        return new MobileEmailNotification();
    }
    
    @Override
    public SMSNotification createSMSNotification() {
        return new MobileSMSNotification();
    }
    
    @Override
    public PushNotification createPushNotification() {
        return new MobilePushNotification();
    }
    
    @Override
    public String getPlatformName() {
        return "MOBILE";
    }
}

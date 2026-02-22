// Web Platform Notification Factory
public class WebNotificationFactory implements NotificationFactory {
    @Override
    public EmailNotification createEmailNotification() {
        return new WebEmailNotification();
    }
    
    @Override
    public SMSNotification createSMSNotification() {
        return new WebSMSNotification();
    }
    
    @Override
    public PushNotification createPushNotification() {
        return new WebPushNotification();
    }
    
    @Override
    public String getPlatformName() {
        return "WEB";
    }
}

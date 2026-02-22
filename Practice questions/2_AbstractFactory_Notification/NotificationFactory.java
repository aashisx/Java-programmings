// Abstract Factory Interface
public interface NotificationFactory {
    EmailNotification createEmailNotification();
    SMSNotification createSMSNotification();
    PushNotification createPushNotification();
    String getPlatformName();
}

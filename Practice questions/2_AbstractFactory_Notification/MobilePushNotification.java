// Mobile Platform Push Notification
public class MobilePushNotification implements PushNotification {
    @Override
    public void sendPush(String deviceId, String title, String message) {
        System.out.println("[MOBILE PUSH]");
        System.out.println("  Device: " + deviceId);
        System.out.println("  Title: " + title);
        System.out.println("  Message: " + message);
        System.out.println("  Sent via Firebase Cloud Messaging (FCM)");
    }
}

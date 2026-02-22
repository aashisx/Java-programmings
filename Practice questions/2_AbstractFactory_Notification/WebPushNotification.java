// Web Platform Push Notification
public class WebPushNotification implements PushNotification {
    @Override
    public void sendPush(String deviceId, String title, String message) {
        System.out.println("[WEB PUSH]");
        System.out.println("  Device: " + deviceId);
        System.out.println("  Title: " + title);
        System.out.println("  Message: " + message);
        System.out.println("  Sent via Web Push API (Service Worker)");
    }
}

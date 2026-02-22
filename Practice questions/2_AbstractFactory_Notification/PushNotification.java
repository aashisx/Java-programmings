// Push Notification Interface
public interface PushNotification {
    void sendPush(String deviceId, String title, String message);
}

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Notification {
    private static int nextId = 1;
    private String notificationId;
    private String userId;
    private String message;
    private String type;          // e.g., "RideUpdate", "Payment"
    private LocalDateTime timestamp;

    // Static list to simulate storing notifications
    private static List<Notification> allNotifications = new ArrayList<>();

    public Notification(String userId, String message, String type) {
        this.notificationId = "N" + nextId++;
        this.userId = userId;
        this.message = message;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and setters
    public String getNotificationId() { return notificationId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public LocalDateTime getTimestamp() { return timestamp; }

    // Method to send notification
    public void sendNotification() {
        System.out.println("Sending notification to user " + userId + ": " + message);
        allNotifications.add(this);
    }

    // Method to schedule notification (simulate delay)
    public void scheduleNotification(LocalDateTime scheduledTime) {
        System.out.println("Notification scheduled for " + scheduledTime + " for user " + userId);
        // For demo, we'll just add to list immediately
        allNotifications.add(this);
    }

    // Retrieve all notifications (for demo)
    public static List<Notification> getAllNotifications() {
        return allNotifications;
    }
}

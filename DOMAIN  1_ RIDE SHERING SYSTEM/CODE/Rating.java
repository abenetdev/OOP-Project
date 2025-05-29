import java.util.ArrayList;
import java.util.List;

public class Rating {
    private static int nextId = 1;
    private String ratingId;
    private String rideId;
    private String fromUserId;
    private String toUserId;
    private int score;          // 1 to 5
    private String comments;

    // Static list to store all ratings (simulate storage)
    private static List<Rating> allRatings = new ArrayList<>();

    public Rating(String rideId, String fromUserId, String toUserId, int score, String comments) {
        this.ratingId = "RT" + nextId++;
        this.rideId = rideId;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.score = score;
        this.comments = comments;
    }

    // Getters and Setters
    public String getRatingId() { return ratingId; }
    public String getRideId() { return rideId; }
    public String getFromUserId() { return fromUserId; }
    public String getToUserId() { return toUserId; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    // Submit rating (adds to static list)
    public void submitRating() {
        System.out.println("Submitting rating: " + score + " stars. Comments: " + comments);
        allRatings.add(this);
    }

    // View all ratings (for demonstration)
    public static List<Rating> viewRatings() {
        return allRatings;
    }
}

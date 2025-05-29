import java.time.LocalDateTime;

public class Payment {
    private static int nextId = 1;
    private String paymentId;
    private String rideId;
    private String riderId;
    private String method;      // e.g., Credit Card, Cash, Wallet
    private float amount;
    private LocalDateTime timestamp;
    private boolean isVerified;

    public Payment(String rideId, String riderId, String method, float amount) {
        this.paymentId = "P" + nextId++;
        this.rideId = rideId;
        this.riderId = riderId;
        this.method = method;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.isVerified = false;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getRideId() {
        return rideId;
    }

    public String getRiderId() {
        return riderId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public boolean isVerified() {
        return isVerified;
    }

    // Simulate payment processing logic
    public boolean processPayment() {
        System.out.println("Processing payment of $" + amount + " using " + method + "...");
        // Basic mock validation
        if (amount <= 0) {
            System.out.println("Invalid payment amount.");
            isVerified = false;
            return false;
        }
        // Simulate successful payment
        isVerified = true;
        System.out.println("Payment processed successfully.");
        return true;
    }

    // Simulate verifying payment status
    public boolean verifyPayment() {
        if (isVerified) {
            System.out.println("Payment " + paymentId + " is verified.");
            return true;
        } else {
            System.out.println("Payment " + paymentId + " is NOT verified.");
            return false;
        }
    }
}

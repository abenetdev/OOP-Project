import java.util.Date;

public class Payment {
    private static int counter = 0;
    private String paymentId;
    private double amount;
    private PaymentMethod method;
    private Date timestamp;

    public Payment(double amount, PaymentMethod method) {
        this.paymentId = "PAY" + (++counter);
        this.amount = amount;
        this.method = method;
        this.timestamp = new Date();
    }

    public String getPaymentId() { return paymentId; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public PaymentMethod getMethod() { return method; }
    public void setMethod(PaymentMethod method) { this.method = method; }

    public Date getTimestamp() { return timestamp; }

    public boolean process() {
        System.out.println("Processing payment " + paymentId + " of amount " + amount);
        return true;
    }
}

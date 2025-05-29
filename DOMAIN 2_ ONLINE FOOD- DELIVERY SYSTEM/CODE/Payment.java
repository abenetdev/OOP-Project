public class Payment 
{
    private static int idCounter = 1;
    private int paymentId;
    private int orderId;
    private double amount;
    private String method;
    private boolean status;

    public Payment(int orderId, double amount, String method)
    {
        this.paymentId = idCounter++;
        this.orderId = orderId;
        this.amount = amount;
        this.method = method;
        this.status = false;
    }

    public int getPaymentId() 
    { 
        return paymentId; 
    }
    public int getOrderId() 
    { 
        return orderId; 
    }
    public double getAmount() 
    {
        return amount; 
    }
    public String getMethod() 
    {
        return method; 
    }
    public boolean isStatus()
    {
        return status; 
    }
    public void completePayment()
    { 
        this.status = true; 
    }
}

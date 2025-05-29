public class Offer
{
    private static int idCounter = 1;
    private int offerId;
    private User buyer;
    private double amount;

    public Offer(User buyer, double amount)
    {
        this.offerId = idCounter++;
        this.buyer = buyer;
        this.amount = amount;
    }

    public int getOfferId() 
    {
        return offerId;
    }

    public User getBuyer() 
    {
        return buyer;
    }

    public double getAmount() 
    {
        return amount;
    }
}

public class Transaction 
{
    private static int idCounter = 1;
    private int transactionId;
    private Listing listing;
    private Offer offer;

    public Transaction(Listing listing, Offer offer) 
    {
        this.transactionId = idCounter++;
        this.listing = listing;
        this.offer = offer;
    }

    public int getTransactionId() 
    {
        return transactionId;
    }

    public Listing getListing()
    {
        return listing;
    }

    public Offer getOffer()
    {
        return offer;
    }
}

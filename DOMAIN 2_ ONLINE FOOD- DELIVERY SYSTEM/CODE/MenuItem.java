public class MenuItem 
{
    private static int idCounter = 1;
    private int itemId;
    private String name;
    private double price;
    private boolean available;

    public MenuItem(String name, double price, boolean available)
    {
        this.itemId = idCounter++;
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public int getItemId() 
    { 
        return itemId;
    }
    public String getName() 
    {
        return name; 
    }
    public void setName(String name) 
    {
        this.name = name; 
    }
    public double getPrice() 
    {
        return price; 
    }
    public void setPrice(double price)
    { 
        this.price = price;
    }
    public boolean isAvailable() 
    { 
        return available;
    }
    public void setAvailable(boolean available) 
    { 
        this.available = available;
    }
}

public class Property
{
    private static int idCounter = 1;
    private int propertyId;
    private String address;
    private String type;
    private double size;

    public Property(String address, String type, double size) 
    {
        this.propertyId = idCounter++;
        this.address = address;
        this.type = type;
        this.size = size;
    }

    public int getPropertyId()
    {
        return propertyId;
    }

    public String getAddress()
    {
        return address;
    }

    public String getType() {
        return type;
    }

    public double getSize() 
    {
        return size;
    }
}

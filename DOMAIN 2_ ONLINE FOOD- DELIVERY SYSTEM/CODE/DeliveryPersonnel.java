public class DeliveryPersonnel 
{
    private static int idCounter = 1;
    private int deliveryId;
    private String name;
    private String vehicle;
    private String status;

    public DeliveryPersonnel(String name, String vehicle)
    {
        this.deliveryId = idCounter++;
        this.name = name;
        this.vehicle = vehicle;
        this.status = "Available";
    }

    public int getDeliveryId() 
    { 
        return deliveryId; 
    }
    public String getName()
    {
        return name; 
    }
    public String getVehicle() 
    { 
        return vehicle;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) 
    {
        this.status = status; 
    }
}

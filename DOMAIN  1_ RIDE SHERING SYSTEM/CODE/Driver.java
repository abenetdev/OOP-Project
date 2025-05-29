public class Driver extends User
{
    private String licenseNo;
    private String status;
    private float rating;
    private Location currentLocation;
    private Vehicle vehicle;

public Driver(String name, String email, String phone, String password, String licenseNo, Vehicle vehicle)
    {
        super(name, email, phone, password);
        this.licenseNo = licenseNo;
        this.vehicle = vehicle;
        this.status = "Offline";
    }

public boolean acceptRide(String rideId)
    {
        // logic here
        return true;
    }

public void updateStatus(String status)
    {
        this.status = status;
    }

public void updateLocation(Location location)
    {
        this.currentLocation = location;
    }

public void completeRide()
    {
        // logic here
    }
}
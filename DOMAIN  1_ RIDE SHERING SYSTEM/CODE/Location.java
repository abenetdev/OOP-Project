public class Location
{
    private String locationId;
    private double latitude;
    private double longitude;
    private String address;
    private String city;

public Location(String locationId, double latitude, double longitude, String address, String city)
    {
        this.locationId = locationId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.city = city;
    }

public float getDistanceTo(Location other)
    {
        return 0.0f;
    }

public boolean validateCoordinates()
    {
        return true;
    }
}
import java.util.List;
import java.util.ArrayList;
public class Rider extends User
{
    private Location currentLocation;
    private List<Ride> rideHistory = new ArrayList<>();

public Rider(String name, String email, String phone, String password, Location location)
    {
        super(name, email, phone, password);
        this.currentLocation = location;
    }

public Ride requestRide(Location pickup, Location dropoff)
    {
        return new Ride(this.getUserId(), pickup, dropoff);
    }

public List<Ride> viewRideHistory()
    {
        return rideHistory;
    }
}
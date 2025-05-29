import java.time.LocalDateTime;
public class Ride
{
    private static int nextId = 1;
    private String rideId;
    private String riderId;
    private String driverId;
    private Location pickup;
    private Location dropoff;
    private float fare;
    private String status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

public Ride(String riderId, Location pickup, Location dropoff)
    {
        this.rideId = "R" + nextId++;
        this.riderId = riderId;
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.status = "Requested";
    }

public void updateStatus(String newStatus)
    {
        this.status = newStatus;
    }

private float calculateFare()
    {
        return 10.0f; // placeholder
    }

public void assignDriver(String driverId)
    {
        this.driverId = driverId;
    }
}
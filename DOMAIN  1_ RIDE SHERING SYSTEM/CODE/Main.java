import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Create locations
        Location pickup = new Location("L1", 40.7128, -74.0060, "123 Main St", "New York");
        Location dropoff = new Location("L2", 40.7580, -73.9855, "456 Broadway", "New York");

        // Create a vehicle
        Vehicle vehicle = new Vehicle("D1", "Toyota Prius", "XYZ-1234", "Blue");

        // Create driver
        Driver driver = new Driver("Alice", "alice@example.com", "555-0100", "password", "LIC123", vehicle);

        // Create rider
        Rider rider = new Rider("Bob", "bob@example.com", "555-0200", "password", pickup);

        // Rider requests a ride
        Ride ride = rider.requestRide(pickup, dropoff);
        System.out.println("Ride requested with ID: " + ride.getRideId());

        // Driver accepts the ride
        boolean accepted = driver.acceptRide(ride.getRideId());
        if (accepted) {
            ride.assignDriver(driver.getUserId());
            ride.updateStatus("Accepted");
            System.out.println("Ride accepted by driver: " + driver.getName());
        }

        // Start and complete the ride
        ride.updateStatus("In Progress");
        System.out.println("Ride is in progress...");

        ride.updateStatus("Completed");
        System.out.println("Ride completed.");

        // Payment
        Payment payment = new Payment(ride.getRideId(), rider.getUserId(), "Credit Card", 29.99f);
        if (payment.processPayment()) {
            payment.verifyPayment();
        }

        // Submit a rating
        Rating rating = new Rating(ride.getRideId(), rider.getUserId(), driver.getUserId(), 5, "Great experience!");
        rating.submitRating();

        // Send a notification
        Notification notification = new Notification(rider.getUserId(), "Thanks for riding with us!", "RideUpdate");
        notification.sendNotification();

        // Done
        System.out.println("\nDemo completed.");
    }
}

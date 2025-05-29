
public class Vehicle {
    private static int idCounter = 1;
    private String vehicleID;
    private String make;
    private String model;
    private String type;
    private boolean availabilityStatus;
    private double rentalRatePerDay;

    public Vehicle(String make, String model, String type, double rentalRatePerDay) {
        this.vehicleID = "VEH" + idCounter++;
        this.make = make;
        this.model = model;
        this.type = type;
        this.rentalRatePerDay = rentalRatePerDay;
        this.availabilityStatus = true;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return availabilityStatus;
    }

    public double getRentalRatePerDay() {
        return rentalRatePerDay;
    }

    public void setAvailability(boolean status) {
        this.availabilityStatus = status;
    }
}

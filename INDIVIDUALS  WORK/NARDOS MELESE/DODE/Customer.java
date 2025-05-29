import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static int idCounter = 1;
    private String customerID;
    private String name;
    private String licenseNumber;
    private String contactInfo;
    private List<Reservation> reservations;

    public Customer(String name, String licenseNumber, String contactInfo) {
        this.customerID = "CUST" + idCounter++;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.contactInfo = contactInfo;
        this.reservations = new ArrayList<>();
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }
}

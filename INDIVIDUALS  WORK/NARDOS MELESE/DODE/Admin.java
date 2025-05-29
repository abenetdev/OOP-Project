
public class Admin {
    private static int idCounter = 1;
    private String adminID;
    private String name;

    public Admin(String name) {
        this.adminID = "ADM" + idCounter++;
        this.name = name;
    }

    public String getAdminID() {
        return adminID;
    }

    public String getName() {
        return name;
    }

    public void addVehicle() {
        System.out.println("Vehicle added by admin: " + name);
    }

    public void removeVehicle() {
        System.out.println("Vehicle removed by admin: " + name);
    }

    public void updateRentalRate() {
        System.out.println("Rental rate updated by admin: " + name);
    }

    public void viewReports() {
        System.out.println("Reports viewed by admin: " + name);
    }
}

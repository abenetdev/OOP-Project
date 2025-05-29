import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Maintenance {
    private static int idCounter = 1;
    private String maintenanceID;
    private Date serviceDate;
    private String description;
    private List<String> history;

    public Maintenance(Date serviceDate, String description) {
        this.maintenanceID = "MTN" + idCounter++;
        this.serviceDate = serviceDate;
        this.description = description;
        this.history = new ArrayList<>();
        logService();
    }

    public String getMaintenanceID() {
        return maintenanceID;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public String getDescription() {
        return description;
    }

    public void logService() {
        history.add(serviceDate + ": " + description);
    }

    public List<String> getMaintenanceHistory() {
        return history;
    }
}

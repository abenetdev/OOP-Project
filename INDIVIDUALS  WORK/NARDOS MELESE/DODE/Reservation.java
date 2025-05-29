
public class Reservation { private static int idCounter = 1; private String reservationID; private Date startDate; private Date endDate; private String status;

public Reservation(Date startDate, Date endDate, String status) {
    this.reservationID = "RES" + idCounter++;
    this.startDate = startDate;
    this.endDate = endDate;
    this.status = status;
}

public String getReservationID() {
    return reservationID;
}

public Date getStartDate() {
    return startDate;
}

public Date getEndDate() {
    return endDate;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

public void cancelReservation() {
    this.status = "Cancelled";
}

public int calculateDuration() {
    long duration = endDate.getTime() - startDate.getTime();
    return (int) (duration / (1000 * 60 * 60 * 24));
}

}


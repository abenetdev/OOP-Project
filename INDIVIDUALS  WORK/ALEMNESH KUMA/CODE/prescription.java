import java.util.Date;

public class Prescription {
    private static int counter = 0;
    private String prescriptionId;
    private String medication;
    private String dosage;
    private Date startDate;
    private Date endDate;

    public Prescription(String medication, String dosage, Date startDate, Date endDate) {
        this.prescriptionId = "RX" + (++counter);
        this.medication = medication;
        this.dosage = dosage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPrescriptionId() { return prescriptionId; }
    public String getMedication() { return medication; }
    public void setMedication(String medication) { this.medication = medication; }

    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
}

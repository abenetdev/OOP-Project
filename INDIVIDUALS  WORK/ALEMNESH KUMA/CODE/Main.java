import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a provider
        Provider provider = new Provider("Dr. Selam", "Cardiology", "0912-000000");

        // Create a patient
        Patient patient = new Patient("Mekdes Mulu", new Date(2002 - 1900, 5, 25), "0911-123456");

        // Add a medical history entry
        patient.addMedicalHistory("Has a history of high blood pressure");

        // Book an appointment
        Appointment appointment = new Appointment(
            new Date(2025 - 1900, 5, 20, 10, 0),
            new Date(2025 - 1900, 5, 20, 10, 30),
            "Routine check-up"
        );
        patient.addAppointment(appointment);
        provider.addAppointment(appointment);

        // Add a medical record
        MedicalRecord record = new MedicalRecord("Check-up notes", "Mild hypertension");
        record.addTreatment("Prescribed exercise and low-sodium diet");
        patient.addMedicalRecord(record);

        // Output the simulation
        System.out.println("=== Healthcare Management System Simulation ===");
        System.out.println("Patient: " + patient.getName());
        System.out.println("Provider: " + provider.getName() + " - " + provider.getSpecialization());
        System.out.println("Appointments booked: " + patient.getAppointments().size());
        System.out.println("Medical history: " + patient.getMedicalHistory());
        System.out.println("Medical records: " + patient.getMedicalRecords().size());
        System.out.println("Treatments in latest record: " + record.getTreatments());
    }
}
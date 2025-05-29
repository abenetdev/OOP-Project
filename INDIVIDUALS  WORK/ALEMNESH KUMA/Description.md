**Domain 6: HEALTHCARE MANEGMENT SYSTEM**  
The Healthcare Management System supports the end‑to‑end workflow of patient care, from appointment scheduling through treatment, record‑keeping, and billing.  
**Key Functionalities**  
**->Patient Management:**  
capture and safeguard patient demographics, contact details, medical history, allergies and ongoing health metrics.    
**->Provider Management:**  
register healthcare providers (doctors, nurses, specialists), their specializations, credentials and availability.   
**->Appointment Scheduling:**  
allow patients (or staff) to request, confirm, reschedule or cancel visits; enforce conflict‑free booking for providers and rooms; send reminders.    
**->Clinical Records:**  
store diagnoses, treatments, prescriptions, lab results and encounter notes. Maintain full audit trail per record‑update for compliance.    
**->Billing & Payments:**  
generate invoices for services rendered, process insurance claims, record payments/refunds, track outstanding balances.    
**->External Integrations:**  
interface with lab systems (for test orders/results), pharmacy/prescription services, and insurance verification APIs.    
**->Security & Privacy:**  
enforce role‑based access control, data encryption at rest/in‑transit, audit logging, and compliance with HIPAA‑style regulations.   


**INTIAL OBJECT IDENTIFICATION TABLE**  

Object Name | Description
|---------------|------------------
Patient | Individual receiving care.
Provider | Healthcare professional delivering services.
Appointment | Scheduled encounter between patient and provider.
MedicalRecord | Clinical data, diagnoses, treatments, notes.
Prescription | Medication order tied to a patient and prescribing provider.
LabResult | Diagnostic test outcome imported from lab system.
Invoice | Billing document for services rendered.
Payment | Monetary transaction recording patient/insurance payment.


### Update Note - Stage 5 (Full Implementation)

During the full Java implementation phase (Stage 5), a new enum class named `PaymentMethod` was introduced. 

This enum supports the `Payment` class by representing the method used for a payment. It was not included in the initial Stage 2 design but became necessary as the system was completed.

**Enum: PaymentMethod**
```java
public enum PaymentMethod {
    Insurance,
    CreditCard,
    Cash
}

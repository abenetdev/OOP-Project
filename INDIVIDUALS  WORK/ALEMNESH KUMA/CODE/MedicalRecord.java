import java.util.*;
public class MedicalRecord 
{ private String recordId;
  private Date timestamp; 
  private String notes;
  private String diagnosis;
  private List treatments = new ArrayList<>();
public MedicalRecord(String recordId, Date timestamp, String notes, String diagnosis)
     {
         this.recordId = recordId;
         this.timestamp = timestamp;
         this.notes = notes; 
         this.diagnosis = diagnosis;
     }
 public String getRecordId() 
     { 
         return recordId;
     }
 public void setRecordId(String recordId) 
     { 
     this.recordId = recordId;
     }
 public Date getTimestamp() 
     { 
         return timestamp;
     }
 public void setTimestamp(Date timestamp) 
     { 
     this.timestamp = timestamp;
     } 
 public String getNotes()
     {
     return notes;
     } 
 public void setNotes(String notes) 
     { 
     this.notes = notes;
     }
 public String getDiagnosis()
     { 
     return diagnosis;
     }
 public void setDiagnosis(String diagnosis)
     {
     this.diagnosis = diagnosis;
     }
public List<String> getTreatments()
     { 
     return treatments;
     } 
 public void setTreatments(List<String> treatments) 
     {
     this.treatments = treatments;
     }
 public void addTreatment(String treatment) 
     {
     treatments.add(treatment);
     } 
}

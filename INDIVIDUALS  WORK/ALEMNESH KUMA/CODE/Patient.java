import java.util.*;
public class Patient
{ 
  private String patientId;
  private String name;
  private Date dateOfBirth;
  private String contactInfo;
  private List medicalHistory = new ArrayList<>();
public Patient(String patientId, String name, Date dateOfBirth, String contactInfo)
  { 
   this.patientId = patientId; 
   this.name = name;
   this.dateOfBirth = dateOfBirth;
   this.contactInfo = contactInfo;
  }
public String getPatientId() 
  { 
    return patientId; 
  }
public void setPatientId(String patientId)
  {
    this.patientId = patientId;
  } 
public String getName() 
  {
    return name;
  } 
public void setName(String name) 
  { 
    this.name = name;
  }
public Date getDateOfBirth()
  {
    return dateOfBirth;
  } 
public void setDateOfBirth(Date dateOfBirth)
  { 
    this.dateOfBirth = dateOfBirth;
  }
public String getContactInfo()
  {
    return contactInfo; 
  }
public void setContactInfo(String contactInfo)
  { 
    this.contactInfo = contactInfo;
  }
public List<String> getMedicalHistory()
  { 
    return medicalHistory;
  } 
public void setMedicalHistory(List<String> medicalHistory)
  {
    this.medicalHistory = medicalHistory;
  }
  public void addMedicalHistory(String note)
  {
    medicalHistory.add(note);
  } 
}




import java.util.*;
public class Provider 
{ 
    private String providerId;
    private String name;
    private String specialization; 
    private String contactInfo;
    private List<Appointment> appointments;
public Provider(String providerId, String name, String specialization, String contactInfo)
    {
        this.providerId = providerId;
        this.name = name;
        this.specialization = specialization;
        this.contactInfo = contactInfo;
        this.appointments = new ArrayList<>();
    }
public String getProviderId()
    {
        return providerId; 
    }
public void setProviderId(String providerId)
    {
        this.providerId = providerId;
    } 
public String getName()
    {
        return name; 
    } 
public void setName(String name) 
    {
        this.name = name;
    }
public String getSpecialization()
    {
        return specialization;
    }
public void setSpecialization(String specialization) 
    {
        this.specialization = specialization;
    } 
public String getContactInfo()
    {
        return contactInfo;
    }
public void setContactInfo(String contactInfo) 
    { 
        this.contactInfo = contactInfo;
    }
public boolean checkAvailability()
    { 
        return true;
    } 
}
















import java.util.ArrayList;
import java.util.List;

public class User 
{
    private static int idCounter = 1;
    private int userId;
    private String name;
    private String email;
    private List<Property> postedProperties;

    public User(String name, String email)
    {
        this.userId = idCounter++;
        this.name = name;
        this.email = email;
        this.postedProperties = new ArrayList<>();
    }

    public int getUserId() 
    {
        return userId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public List<Property> getPostedProperties() 
    {
        return postedProperties;
    }

    public void addProperty(Property property) 
    {
        this.postedProperties.add(property);
    }
}

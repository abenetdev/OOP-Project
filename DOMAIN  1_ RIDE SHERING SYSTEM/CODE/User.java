public class User
{
    private static int nextId = 1;
    private String userId;
    private String name;
    private String email;
    private String phone;
    private String password;

public User(String name, String email, String phone, String password)
    {
        this.userId = "U" + nextId++;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

public String getUserId()
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
public String getPhone()
    { 
    return phone; 
    }
public void setPhone(String phone)
    {
         this.phone = phone;
    }
public String getPassword()
    {
        return password;
    }
public void setPassword(String password)
    {
    this.password = password;
    }
}

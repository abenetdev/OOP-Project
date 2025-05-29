public class Customer
{
    private static int idCounter = 1;
    private int customerId;
    private String name;
    private String email;
    private String address;

    public Customer(String name, String email, String address
    {
        this.customerId = idCounter++;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public int getCustomerId() 
    {
        return customerId;
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
    public String getAddress() 
    {
        return address;
    }
    public void setAddress(String address)
    { 
        this.address = address; 
    }
}

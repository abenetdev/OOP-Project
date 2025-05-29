import java.util.ArrayList;
import java.util.List;

public class Restaurant
{
    private static int idCounter = 1;
    private int restaurantId;
    private String name;
    private String location;
    private List<MenuItem> menuItems;

    public Restaurant(String name, String location) 
    {
        this.restaurantId = idCounter++;
        this.name = name;
        this.location = location;
        this.menuItems = new ArrayList<>();
    }

    public int getRestaurantId() 
    {
        return restaurantId; 
    }
    public String getName() 
    {
        return name; 
    }
    public void setName(String name)
    { 
        this.name = name;
    }
    public String getLocation() 
    {
        return location;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }
    public List<MenuItem> getMenuItems()
    {
        return menuItems;
    }
    public void addMenuItem(MenuItem item) 
    {
        menuItems.add(item);
    }
}

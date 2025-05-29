import java.util.List;
public class Order
{
    private static int idCounter = 1;
    private int orderId;
    private Customer customer;
    private Restaurant restaurant;
    private List<MenuItem> items;
    private String status;

public Order(Customer customer, Restaurant restaurant, List<MenuItem> items)
    {
        this.orderId = idCounter++;
        this.customer = customer;
        this.restaurant = restaurant;
        this.items = items;
        this.status = "Placed";
    }

public int getOrderId()
    {
        return orderId;
    }
public Customer getCustomer()
    {
        return customer;
    }
public Restaurant getRestaurant()
    {
        return restaurant;
    }
public List<MenuItem> getItems()
    {
        return items;
    }
public String getStatus()
    {
        return status;
    }
public void setStatus(String status)
    {
        this.status = status;
    }
}

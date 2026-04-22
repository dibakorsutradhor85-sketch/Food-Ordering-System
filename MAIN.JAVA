import java.util.ArrayList;


abstract class FoodItem {


    private String name;
    private double price;

    FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    
    abstract void showItem();
}



class Burger extends FoodItem {

    private String size;

    Burger(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    
    void showItem() {
        System.out.println("Burger Name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Size: " + size);
        System.out.println("--------------------");
    }
}



class Pizza extends FoodItem {

    private String topping;

    Pizza(String name, double price, String topping) {
        super(name, price);
        this.topping = topping;
    }

    
    void showItem() {
        System.out.println("Pizza Name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Topping: " + topping);
        System.out.println("--------------------");
    }
}



class Customer {

    private String customerName;
    private String address;

    Customer(String customerName, String address) {
        this.customerName = customerName;
        this.address = address;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    void showCustomer() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Address: " + address);
    }
}



public class FoodOrderingSystem {

    public static void main(String[] args) {

        ArrayList<FoodItem> menu = new ArrayList<>();

        
        Burger b1 = new Burger("Chicken Burger", 5.5, "Large");
        Pizza p1 = new Pizza("Pepperoni Pizza", 8.0, "Extra Cheese");

        menu.add(b1);
        menu.add(p1);

        
        Customer c1 = Customer("Ashik", "Dhaka");

        c1.showCustomer();

        System.out.println("\nMenu:");

    
        for (FoodItem f : menu) {
            f.showItem();
        }
    }
}

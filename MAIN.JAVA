
import java.util.ArrayList;
import java.util.Scanner;

abstract class FoodItem {
    private String name;
    private double price;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract double calculatePrice();
    public abstract void showItem();
}

class Burger extends FoodItem {
    private String size;

    public Burger(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    @Override
    public double calculatePrice() {
        if (size.equalsIgnoreCase("Large")) return getPrice() + 2;
        if (size.equalsIgnoreCase("Medium")) return getPrice() + 1;
        return getPrice();
    }

    @Override
    public void showItem() {
        System.out.println("Burger: " + getName() + " | Size: " + size + " | Price: " + calculatePrice());
    }
}

class Pizza extends FoodItem {
    private String topping;

    public Pizza(String name, double price, String topping) {
        super(name, price);
        this.topping = topping;
    }

    @Override
    public double calculatePrice() {
        if (topping.equalsIgnoreCase("Extra Cheese")) return getPrice() + 3;
        return getPrice();
    }

    @Override
    public void showItem() {
        System.out.println("Pizza: " + getName() + " | Topping: " + topping + " | Price: " + calculatePrice());
    }
}

class Drink extends FoodItem {
    private boolean isCold;

    public Drink(String name, double price, boolean isCold) {
        super(name, price);
        this.isCold = isCold;
    }

    @Override
    public double calculatePrice() {
        return isCold ? getPrice() + 0.5 : getPrice();
    }

    @Override
    public void showItem() {
        System.out.println("Drink: " + getName() + " | Cold: " + isCold + " | Price: " + calculatePrice());
    }
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void showCustomer() {
        System.out.println("Customer: " + name);
    }
}

class Order {
    private ArrayList<FoodItem> items = new ArrayList<>();

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (FoodItem f : items) {
            total += f.calculatePrice();
        }
        return total;
    }

    public void showOrder() {
        System.out.println("\nOrder Details:");
        for (FoodItem f : items) {
            f.showItem();
        }
        System.out.println("Total Bill: " + getTotal());
    }
}

public class FoodOrderingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Customer c = new Customer("Ashik");
        Order order = new Order();

        while (true) {
            System.out.println("\n1. Burger\n2. Pizza\n3. Drink\n4. Checkout");
            int choice = sc.nextInt();

            if (choice == 1) {
                order.addItem(new Burger("Chicken Burger", 5.0, "Large"));
            } else if (choice == 2) {
                order.addItem(new Pizza("Pepperoni", 7.0, "Extra Cheese"));
            } else if (choice == 3) {
                order.addItem(new Drink("Coke", 2.0, true));
            } else {
                break;
            }
        }

        c.showCustomer();
        order.showOrder();
    }
}
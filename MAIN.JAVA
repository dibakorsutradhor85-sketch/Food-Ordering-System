import java.util.ArrayList;
import java.util.Scanner;

abstract class FoodItem {
    private int id;
    private String name;
    private double price;

    public FoodItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public abstract void showItem();
}

class Burger extends FoodItem {
    public Burger(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void showItem() {
        System.out.println(getId() + ". Burger: " + getName() + " - $" + getPrice());
    }
}

class Pizza extends FoodItem {
    public Pizza(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void showItem() {
        System.out.println(getId() + ". Pizza: " + getName() + " - $" + getPrice());
    }
}

class Drink extends FoodItem {
    public Drink(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void showItem() {
        System.out.println(getId() + ". Drink: " + getName() + " - $" + getPrice());
    }
}

class Order {
    private ArrayList<FoodItem> items = new ArrayList<>();

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public void showOrder() {
        double total = 0;
        System.out.println("\nYour Order:");
        for (FoodItem item : items) {
            item.showItem();
            total += item.getPrice();
        }
        System.out.println("Total Bill: $" + total);
    }
}

public class FoodOrderingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<FoodItem> menu = new ArrayList<>();
        menu.add(new Burger(1, "Chicken Burger", 5.0));
        menu.add(new Pizza(2, "Cheese Pizza", 8.0));
        menu.add(new Drink(3, "Coke", 2.0));

        Order order = new Order();

        while (true) {
            System.out.println("\n--- MENU ---");
            for (FoodItem item : menu) {
                item.showItem();
            }
            System.out.println("0. Exit");

            System.out.print("Select item ID: ");
            int choice = sc.nextInt();

            if (choice == 0) break;

            boolean found = false;
            for (FoodItem item : menu) {
                if (item.getId() == choice) {
                    order.addItem(item);
                    System.out.println(item.getName() + " added!");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Invalid choice!");
            }
        }

        order.showOrder();
        sc.close();
    }
}
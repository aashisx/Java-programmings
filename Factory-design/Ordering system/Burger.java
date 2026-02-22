// Concrete class for Burger
public class Burger implements Food {
    private String name;
    private double price;
    
    public Burger() {
        this.name = "Classic Cheese Burger";
        this.price = 250.00;
    }
    
    @Override
    public void prepare() {
        System.out.println("\n--- Preparing " + name + " ---");
        System.out.println("Step 1: Grilling beef patty...");
        System.out.println("Step 2: Toasting burger buns...");
        System.out.println("Step 3: Adding lettuce and tomato...");
        System.out.println("Step 4: Adding cheese slice...");
        System.out.println("Step 5: Assembling the burger...");
        System.out.println("Your " + name + " is ready!");
    }
    
    @Override
    public String getFoodType() {
        return "BURGER";
    }
    
    @Override
    public double getPrice() {
        return price;
    }
}

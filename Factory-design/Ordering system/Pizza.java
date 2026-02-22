// Concrete class for Pizza
public class Pizza implements Food {
    private String name;
    private double price;
    
    public Pizza() {
        this.name = "Margherita Pizza";
        this.price = 450.00;
    }
    
    @Override
    public void prepare() {
        System.out.println("\n--- Preparing " + name + " ---");
        System.out.println("Step 1: Making pizza dough...");
        System.out.println("Step 2: Adding tomato sauce...");
        System.out.println("Step 3: Adding mozzarella cheese...");
        System.out.println("Step 4: Adding fresh basil...");
        System.out.println("Step 5: Baking in oven at 450°F...");
        System.out.println("Your " + name + " is ready!");
    }
    
    @Override
    public String getFoodType() {
        return "PIZZA";
    }
    
    @Override
    public double getPrice() {
        return price;
    }
}

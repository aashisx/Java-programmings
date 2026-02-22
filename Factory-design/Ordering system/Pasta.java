// Concrete class for Pasta
public class Pasta implements Food {
    private String name;
    private double price;
    
    public Pasta() {
        this.name = "Spaghetti Carbonara";
        this.price = 350.00;
    }
    
    @Override
    public void prepare() {
        System.out.println("\n--- Preparing " + name + " ---");
        System.out.println("Step 1: Boiling spaghetti...");
        System.out.println("Step 2: Frying bacon pieces...");
        System.out.println("Step 3: Preparing egg and cheese mixture...");
        System.out.println("Step 4: Combining pasta with sauce...");
        System.out.println("Step 5: Garnishing with parsley...");
        System.out.println("Your " + name + " is ready!");
    }
    
    @Override
    public String getFoodType() {
        return "PASTA";
    }
    
    @Override
    public double getPrice() {
        return price;
    }
}

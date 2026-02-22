import java.util.Scanner;

// Main class to test the Factory Design Pattern
public class FoodMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FoodFactory foodFactory = new FoodFactory();
        
        System.out.println("======================================");
        System.out.println("   FOOD ORDERING SYSTEM");
        System.out.println("======================================");
        
        while (true) {
            System.out.println("\nAvailable Food Items:");
            System.out.println("1. PIZZA   - Rs. 450");
            System.out.println("2. BURGER  - Rs. 250");
            System.out.println("3. PASTA   - Rs. 350");
            System.out.println("4. EXIT");
            System.out.print("\nEnter your choice (PIZZA/BURGER/PASTA/EXIT): ");
            
            String choice = scanner.nextLine().trim();
            
            if (choice.equalsIgnoreCase("EXIT") || choice.equals("4")) {
                System.out.println("Thank you for visiting! Enjoy your meal!");
                break;
            }
            
            // Use factory to create food
            Food food = foodFactory.createFood(choice);
            
            if (food != null) {
                System.out.println("\n*** Order Received: " + food.getFoodType() + " ***");
                food.prepare();
                System.out.println("\n--- Bill ---");
                System.out.println("Item: " + food.getFoodType());
                System.out.println("Price: Rs. " + food.getPrice());
                System.out.println("------------");
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
        
        scanner.close();
    }
}

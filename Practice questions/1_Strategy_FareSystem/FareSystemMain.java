import java.util.Scanner;

// Main class demonstrating Strategy Pattern with Open-Closed Principle
public class FareSystemMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FareCalculator calculator = new FareCalculator(new StandardFareStrategy());
        
        System.out.println("==========================================");
        System.out.println("   PUBLIC TRANSPORT FARE CALCULATOR");
        System.out.println("   (Strategy + Open-Closed Principle)");
        System.out.println("==========================================");
        
        while (true) {
            System.out.println("\nSelect Fare Strategy:");
            System.out.println("1. Standard Fare");
            System.out.println("2. Peak Hour Fare");
            System.out.println("3. Discounted Fare");
            System.out.println("4. EXIT");
            System.out.print("Choice: ");
            
            String choice = scanner.nextLine().trim();
            
            if (choice.equals("4")) {
                System.out.println("Thank you for using Fare Calculator!");
                break;
            }
            
            // Switch strategy at runtime
            switch (choice) {
                case "1":
                    calculator.setFareStrategy(new StandardFareStrategy());
                    break;
                case "2":
                    calculator.setFareStrategy(new PeakHourFareStrategy());
                    break;
                case "3":
                    calculator.setFareStrategy(new DiscountedFareStrategy());
                    break;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }
            
            System.out.print("Enter distance (km): ");
            double distance = Double.parseDouble(scanner.nextLine().trim());
            
            System.out.print("Enter time of day (PEAK/OFFPEAK): ");
            String timeOfDay = scanner.nextLine().trim();
            
            System.out.print("Enter passenger type (REGULAR/STUDENT/SENIOR/CHILD/DISABLED): ");
            String passengerType = scanner.nextLine().trim();
            
            System.out.println();
            calculator.printFareDetails(distance, timeOfDay, passengerType);
        }
        
        scanner.close();
        
        // Demonstrate runtime strategy switching
        System.out.println("\n=== DEMONSTRATING RUNTIME STRATEGY SWITCHING ===\n");
        
        FareCalculator demo = new FareCalculator(new StandardFareStrategy());
        double distance = 15.0;
        
        System.out.println("Same trip (15 km) with different strategies:\n");
        
        demo.setFareStrategy(new StandardFareStrategy());
        demo.printFareDetails(distance, "OFFPEAK", "REGULAR");
        
        demo.setFareStrategy(new PeakHourFareStrategy());
        demo.printFareDetails(distance, "PEAK", "REGULAR");
        
        demo.setFareStrategy(new DiscountedFareStrategy());
        demo.printFareDetails(distance, "OFFPEAK", "STUDENT");
    }
}

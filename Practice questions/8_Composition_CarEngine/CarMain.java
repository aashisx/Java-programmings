import java.util.Scanner;

// Main class demonstrating Composition
public class CarMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=============================================");
        System.out.println("   CAR - ENGINE COMPOSITION DEMO");
        System.out.println("   (Composition: Car ♦────── Engine)");
        System.out.println("=============================================\n");
        
        // Create a car - Engine is automatically created inside
        Car myCar = new Car(
            "CAR-001",
            "Toyota",
            "Camry",
            2024,
            "V6 Gasoline",
            301,
            3.5
        );
        
        while (true) {
            System.out.println("\n--- Car Control Menu ---");
            System.out.println("1. Start Car");
            System.out.println("2. Stop Car");
            System.out.println("3. Accelerate");
            System.out.println("4. Brake");
            System.out.println("5. View Car Status");
            System.out.println("6. View Engine Info");
            System.out.println("7. Create New Car");
            System.out.println("8. Demonstrate Composition");
            System.out.println("9. EXIT");
            System.out.print("Choice: ");
            
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    myCar.startCar();
                    break;
                case "2":
                    myCar.stopCar();
                    break;
                case "3":
                    myCar.accelerate();
                    break;
                case "4":
                    myCar.brake();
                    break;
                case "5":
                    myCar.displayStatus();
                    break;
                case "6":
                    System.out.println("\n" + myCar.getEngineInfo());
                    break;
                case "7":
                    System.out.print("Enter car brand: ");
                    String brand = scanner.nextLine().trim();
                    System.out.print("Enter car model: ");
                    String model = scanner.nextLine().trim();
                    System.out.print("Enter year: ");
                    int year = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Enter engine type: ");
                    String engineType = scanner.nextLine().trim();
                    System.out.print("Enter horsepower: ");
                    int hp = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Enter displacement (L): ");
                    double disp = Double.parseDouble(scanner.nextLine().trim());
                    
                    myCar = new Car("CAR-" + System.currentTimeMillis() % 1000, 
                                   brand, model, year, engineType, hp, disp);
                    break;
                case "8":
                    demonstrateComposition();
                    break;
                case "9":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    private static void demonstrateComposition() {
        System.out.println("\n============================================");
        System.out.println("DEMONSTRATING COMPOSITION");
        System.out.println("============================================");
        
        System.out.println("\n1. UML Relationship:");
        System.out.println("   Car ♦────── Engine");
        System.out.println("   (1)         (1)");
        System.out.println("   Filled diamond = Composition (strong ownership)");
        
        System.out.println("\n2. Creating a Car (Engine created automatically):");
        Car demoCar = new Car("DEMO-001", "Honda", "Civic", 2024, 
                              "Turbocharged I4", 180, 1.5);
        
        System.out.println("\n3. Attempting to access Engine directly:");
        System.out.println("   // Engine engine = car.getEngine(); // ERROR - No such method!");
        System.out.println("   // Engine engine = new Engine(...); // ERROR - Package private!");
        System.out.println("   Only Car can create and control its Engine.");
        
        System.out.println("\n4. Controlling Engine through Car interface:");
        demoCar.startCar();
        demoCar.accelerate();
        demoCar.accelerate();
        System.out.println("\n   Engine info (read-only): " + demoCar.getEngineInfo());
        
        System.out.println("\n5. Engine lifecycle tied to Car:");
        System.out.println("   - Engine created when Car is created");
        System.out.println("   - Engine destroyed when Car is garbage collected");
        System.out.println("   - Engine cannot exist independently");
        
        System.out.println("\n============================================");
        System.out.println("KEY COMPOSITION PRINCIPLES:");
        System.out.println("- Car OWNS Engine (strong ownership)");
        System.out.println("- Engine cannot exist without Car");
        System.out.println("- Engine created in Car's constructor");
        System.out.println("- No direct access to Engine from outside");
        System.out.println("- Car exposes controlled interface to Engine");
        System.out.println("============================================");
    }
}

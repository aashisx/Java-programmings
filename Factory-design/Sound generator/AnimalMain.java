import java.util.Scanner;

// Main class to test the Factory Design Pattern
public class AnimalMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalFactory animalFactory = new AnimalFactory();
        
        System.out.println("================================");
        System.out.println("   ANIMAL SOUND GENERATOR");
        System.out.println("================================");
        
        while (true) {
            System.out.println("\nAvailable Animals:");
            System.out.println("1. DOG");
            System.out.println("2. CAT");
            System.out.println("3. COW");
            System.out.println("4. EXIT");
            System.out.print("\nEnter your choice (DOG/CAT/COW/EXIT): ");
            
            String choice = scanner.nextLine().trim();
            
            if (choice.equalsIgnoreCase("EXIT") || choice.equals("4")) {
                System.out.println("Thank you for using Animal Sound Generator!");
                break;
            }
            
            // Use factory to create animal
            Animal animal = animalFactory.createAnimal(choice);
            
            if (animal != null) {
                System.out.println("\n*** Animal Created: " + animal.getAnimalType() + " ***");
                animal.sound();
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
        
        scanner.close();
    }
}

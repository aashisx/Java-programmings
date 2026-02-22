import java.util.Scanner;

// Main class demonstrating Command Pattern with Undo/Redo
public class SmartHomeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=============================================");
        System.out.println("   SMART HOME CONTROLLER");
        System.out.println("   (Command Pattern + Undo/Redo)");
        System.out.println("=============================================\n");
        
        // Create receivers
        Light livingRoomLight = new Light("Living Room");
        Light bedroomLight = new Light("Bedroom");
        Door frontDoor = new Door("Front");
        Door garageDoor = new Door("Garage");
        
        // Create invoker
        SmartHomeController controller = new SmartHomeController();
        
        while (true) {
            System.out.println("\n--- Smart Home Menu ---");
            System.out.println("1. Turn ON Living Room Light");
            System.out.println("2. Turn OFF Living Room Light");
            System.out.println("3. Turn ON Bedroom Light");
            System.out.println("4. Turn OFF Bedroom Light");
            System.out.println("5. Open Front Door");
            System.out.println("6. Close Front Door");
            System.out.println("7. Open Garage Door");
            System.out.println("8. Close Garage Door");
            System.out.println("9. UNDO");
            System.out.println("10. REDO");
            System.out.println("11. View Device Status");
            System.out.println("12. View Command History");
            System.out.println("13. Demonstrate Undo/Redo");
            System.out.println("14. EXIT");
            System.out.print("Choice: ");
            
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    controller.executeCommand(new LightOnCommand(livingRoomLight));
                    break;
                case "2":
                    controller.executeCommand(new LightOffCommand(livingRoomLight));
                    break;
                case "3":
                    controller.executeCommand(new LightOnCommand(bedroomLight));
                    break;
                case "4":
                    controller.executeCommand(new LightOffCommand(bedroomLight));
                    break;
                case "5":
                    controller.executeCommand(new DoorOpenCommand(frontDoor));
                    break;
                case "6":
                    controller.executeCommand(new DoorCloseCommand(frontDoor));
                    break;
                case "7":
                    controller.executeCommand(new DoorOpenCommand(garageDoor));
                    break;
                case "8":
                    controller.executeCommand(new DoorCloseCommand(garageDoor));
                    break;
                case "9":
                    controller.undo();
                    break;
                case "10":
                    controller.redo();
                    break;
                case "11":
                    printDeviceStatus(livingRoomLight, bedroomLight, frontDoor, garageDoor);
                    controller.printStatus();
                    break;
                case "12":
                    controller.printHistory();
                    break;
                case "13":
                    demonstrateUndoRedo();
                    break;
                case "14":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    private static void printDeviceStatus(Light l1, Light l2, Door d1, Door d2) {
        System.out.println("\n--- Device Status ---");
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(d1);
        System.out.println(d2);
    }
    
    private static void demonstrateUndoRedo() {
        System.out.println("\n============================================");
        System.out.println("DEMONSTRATING UNDO/REDO FUNCTIONALITY");
        System.out.println("============================================");
        
        Light demoLight = new Light("Demo Room");
        Door demoDoor = new Door("Demo");
        SmartHomeController demoController = new SmartHomeController();
        
        System.out.println("\n--- Initial State ---");
        System.out.println(demoLight);
        System.out.println(demoDoor);
        
        System.out.println("\n--- Executing Commands ---");
        demoController.executeCommand(new LightOnCommand(demoLight));
        demoController.executeCommand(new DoorOpenCommand(demoDoor));
        demoController.executeCommand(new LightOffCommand(demoLight));
        
        System.out.println("\n--- Current State ---");
        System.out.println(demoLight);
        System.out.println(demoDoor);
        
        System.out.println("\n--- Performing UNDO (x2) ---");
        demoController.undo(); // Undo light off
        demoController.undo(); // Undo door open
        
        System.out.println("\n--- State After Undo ---");
        System.out.println(demoLight);
        System.out.println(demoDoor);
        
        System.out.println("\n--- Performing REDO (x1) ---");
        demoController.redo(); // Redo door open
        
        System.out.println("\n--- Final State ---");
        System.out.println(demoLight);
        System.out.println(demoDoor);
        
        demoController.printHistory();
        
        System.out.println("\n============================================");
        System.out.println("KEY FEATURES DEMONSTRATED:");
        System.out.println("- Commands stored in stacks");
        System.out.println("- Each command knows how to undo itself");
        System.out.println("- Redo stack cleared on new command");
        System.out.println("- State restored correctly on undo/redo");
        System.out.println("============================================");
    }
}

import java.util.Scanner;

// Main class demonstrating Abstract Factory with Dependency Injection
public class NotificationMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===========================================");
        System.out.println("   CROSS-PLATFORM NOTIFICATION SYSTEM");
        System.out.println("   (Abstract Factory + Dependency Injection)");
        System.out.println("===========================================");
        
        while (true) {
            System.out.println("\nSelect Platform:");
            System.out.println("1. WEB Platform");
            System.out.println("2. MOBILE Platform");
            System.out.println("3. Compare Both Platforms");
            System.out.println("4. EXIT");
            System.out.print("Choice: ");
            
            String choice = scanner.nextLine().trim();
            
            if (choice.equals("4")) {
                System.out.println("Thank you for using Notification System!");
                break;
            }
            
            NotificationFactory factory;
            
            switch (choice) {
                case "1":
                    // Inject Web factory at runtime
                    factory = new WebNotificationFactory();
                    demonstrateNotifications(factory);
                    break;
                case "2":
                    // Inject Mobile factory at runtime
                    factory = new MobileNotificationFactory();
                    demonstrateNotifications(factory);
                    break;
                case "3":
                    comparePlatforms();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        
        scanner.close();
    }
    
    private static void demonstrateNotifications(NotificationFactory factory) {
        // Dependency Injection - factory is injected into service
        NotificationService service = new NotificationService(factory);
        
        service.sendAllNotifications(
            "user@example.com",
            "+977-9841234567",
            "device-abc-123",
            "Welcome!",
            "Thank you for signing up to our service."
        );
    }
    
    private static void comparePlatforms() {
        System.out.println("\n========== PLATFORM COMPARISON ==========");
        
        // Same client code, different factory injected
        NotificationService webService = new NotificationService(new WebNotificationFactory());
        NotificationService mobileService = new NotificationService(new MobileNotificationFactory());
        
        String email = "test@example.com";
        String phone = "+977-9800000000";
        String device = "device-xyz-789";
        String subject = "Test Notification";
        String message = "This is a test message.";
        
        webService.sendAllNotifications(email, phone, device, subject, message);
        mobileService.sendAllNotifications(email, phone, device, subject, message);
        
        System.out.println("\n==========================================");
        System.out.println("Notice: Same client code (NotificationService)");
        System.out.println("produces different output based on injected factory!");
        System.out.println("==========================================");
    }
}

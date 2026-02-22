import java.util.Scanner;

// Main class demonstrating Hexagonal Architecture (Ports & Adapters)
public class PaymentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=============================================");
        System.out.println("   PAYMENT PROCESSING MODULE");
        System.out.println("   (Hexagonal Architecture - Ports & Adapters)");
        System.out.println("=============================================\n");
        
        // Create adapters (can be swapped without changing business logic)
        PaymentGatewayPort stripeGateway = new StripePaymentAdapter();
        PaymentGatewayPort paypalGateway = new PayPalPaymentAdapter();
        PaymentRepositoryPort repository = new InMemoryPaymentRepository();
        
        PaymentService currentService = null;
        String lastTransactionId = null;
        
        while (true) {
            System.out.println("\n--- Select Payment Gateway ---");
            System.out.println("1. Use Stripe");
            System.out.println("2. Use PayPal");
            System.out.println("3. Process a Payment");
            System.out.println("4. Process a Refund");
            System.out.println("5. Demonstrate Gateway Switching");
            System.out.println("6. EXIT");
            System.out.print("Choice: ");
            
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    // Inject Stripe adapter
                    currentService = new PaymentService(stripeGateway, repository);
                    System.out.println("\n[CONFIG] Switched to Stripe gateway");
                    break;
                    
                case "2":
                    // Inject PayPal adapter
                    currentService = new PaymentService(paypalGateway, repository);
                    System.out.println("\n[CONFIG] Switched to PayPal gateway");
                    break;
                    
                case "3":
                    if (currentService == null) {
                        System.out.println("\nPlease select a gateway first!");
                        break;
                    }
                    System.out.print("Enter Order ID: ");
                    String orderId = scanner.nextLine().trim();
                    System.out.print("Enter Amount: ");
                    double amount = Double.parseDouble(scanner.nextLine().trim());
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine().trim();
                    
                    PaymentResult result = currentService.processOrder(orderId, amount, "USD", email);
                    if (result.isSuccess()) {
                        lastTransactionId = result.getTransactionId();
                    }
                    break;
                    
                case "4":
                    if (currentService == null) {
                        System.out.println("\nPlease select a gateway first!");
                        break;
                    }
                    if (lastTransactionId == null) {
                        System.out.println("\nNo recent transaction to refund!");
                        break;
                    }
                    System.out.print("Enter refund amount: ");
                    double refundAmount = Double.parseDouble(scanner.nextLine().trim());
                    currentService.refundOrder(lastTransactionId, refundAmount);
                    break;
                    
                case "5":
                    demonstrateGatewaySwitching(stripeGateway, paypalGateway, repository);
                    break;
                    
                case "6":
                    System.out.println("Thank you for using Payment System!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    private static void demonstrateGatewaySwitching(
            PaymentGatewayPort stripe, 
            PaymentGatewayPort paypal,
            PaymentRepositoryPort repository) {
        
        System.out.println("\n============================================");
        System.out.println("DEMONSTRATING GATEWAY SWITCHING");
        System.out.println("(Zero changes to PaymentService business logic)");
        System.out.println("============================================");
        
        // Same business logic, different gateway
        System.out.println("\n>>> Using Stripe:");
        PaymentService stripeService = new PaymentService(stripe, repository);
        stripeService.processOrder("ORD-001", 99.99, "USD", "customer1@example.com");
        
        System.out.println("\n>>> Using PayPal:");
        PaymentService paypalService = new PaymentService(paypal, repository);
        paypalService.processOrder("ORD-002", 149.99, "USD", "customer2@example.com");
        
        System.out.println("\n============================================");
        System.out.println("KEY POINTS:");
        System.out.println("- PaymentService (core logic) never changed");
        System.out.println("- Gateways are injected via constructor");
        System.out.println("- Adding new gateway = new Adapter class only");
        System.out.println("============================================");
    }
}

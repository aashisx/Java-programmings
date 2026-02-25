import java.util.Scanner;

// Main class demonstrating runtime platform switching
// Abstract Factory Pattern - Cross Platform Payment Gateway System
public class PaymentGatewayMain {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("+============================================================+");
        System.out.println("|     CROSS-PLATFORM PAYMENT GATEWAY SYSTEM                  |");
        System.out.println("|           (Abstract Factory Pattern Demo)                  |");
        System.out.println("+============================================================+\n");
        
        // Runtime platform selection
        System.out.println("Select Platform:");
        System.out.println("1. Web Platform");
        System.out.println("2. Mobile Platform");
        System.out.println("3. Demo Both Platforms (Runtime Switching)");
        System.out.print("\nEnter choice (1/2/3): ");
        
        int choice = scanner.nextInt();
        
        // Factory injection at runtime based on user choice
        PaymentFactory factory;
        PaymentService paymentService;
        
        switch (choice) {
            case 1:
                // Inject Web Factory at runtime
                factory = new WebPaymentFactory();
                paymentService = new PaymentService(factory);
                System.out.println("\n========== WEB PLATFORM PAYMENTS ==========\n");
                paymentService.demonstrateAllPayments();
                break;
                
            case 2:
                // Inject Mobile Factory at runtime
                factory = new MobilePaymentFactory();
                paymentService = new PaymentService(factory);
                System.out.println("\n========== MOBILE PLATFORM PAYMENTS ==========\n");
                paymentService.demonstrateAllPayments();
                break;
                
            case 3:
                // Demonstrate runtime switching between platforms
                demonstrateRuntimeSwitching();
                break;
                
            default:
                System.out.println("Invalid choice!");
        }
        
        scanner.close();
    }
    
    // Demonstrates how the same client code can switch platforms at runtime
    private static void demonstrateRuntimeSwitching() {
        System.out.println("\n+============================================================+");
        System.out.println("|        RUNTIME PLATFORM SWITCHING DEMONSTRATION            |");
        System.out.println("+============================================================+\n");
        
        // First: Use Web Platform
        System.out.println(">>> SWITCHING TO WEB PLATFORM <<<\n");
        PaymentFactory webFactory = new WebPaymentFactory();
        PaymentService webService = new PaymentService(webFactory);
        
        System.out.println("--- Processing Credit Card on Web ---");
        webService.processCreditCardPayment(100.00, "4111111111111111");
        
        // Runtime switch: Now use Mobile Platform
        System.out.println(">>> SWITCHING TO MOBILE PLATFORM <<<\n");
        PaymentFactory mobileFactory = new MobilePaymentFactory();
        PaymentService mobileService = new PaymentService(mobileFactory);
        
        System.out.println("--- Processing Credit Card on Mobile ---");
        mobileService.processCreditCardPayment(100.00, "4111111111111111");
        
        // Show UPI on both platforms
        System.out.println("============================================================");
        System.out.println("      SAME UPI PAYMENT - DIFFERENT PLATFORM BEHAVIOR");
        System.out.println("============================================================\n");
        
        System.out.println(">>> WEB UPI PAYMENT <<<");
        webService.processUPIPayment(50.00, "customer@paytm");
        
        System.out.println(">>> MOBILE UPI PAYMENT <<<");
        mobileService.processUPIPayment(50.00, "customer@paytm");
        
        // Show Wallet on both platforms
        System.out.println("============================================================");
        System.out.println("    SAME WALLET PAYMENT - DIFFERENT PLATFORM BEHAVIOR");
        System.out.println("============================================================\n");
        
        System.out.println(">>> WEB WALLET PAYMENT <<<");
        webService.processWalletPayment(75.00, "WALLET_USER001");
        
        System.out.println(">>> MOBILE WALLET PAYMENT <<<");
        mobileService.processWalletPayment(75.00, "WALLET_USER001");
        
        System.out.println("+============================================================+");
        System.out.println("|  DEMONSTRATION COMPLETE - Notice platform-specific output! |");
        System.out.println("+============================================================+");
    }
}

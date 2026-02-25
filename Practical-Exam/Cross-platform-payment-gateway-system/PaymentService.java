// PaymentService - Uses Constructor Injection for dependency injection
// Client code that depends only on abstractions, not concrete classes
public class PaymentService {
    
    // Dependencies on interfaces only - no concrete classes
    private final CreditCardPayment creditCardPayment;
    private final UPIPayment upiPayment;
    private final WalletPayment walletPayment;
    
    // Constructor Injection - Factory is injected at runtime
    public PaymentService(PaymentFactory factory) {
        this.creditCardPayment = factory.createCreditCardPayment();
        this.upiPayment = factory.createUPIPayment();
        this.walletPayment = factory.createWalletPayment();
    }
    
    // Process Credit Card payment
    public void processCreditCardPayment(double amount, String cardNumber) {
        creditCardPayment.validateCard(cardNumber);
        creditCardPayment.processPayment(amount, cardNumber);
    }
    
    // Process UPI payment
    public void processUPIPayment(double amount, String upiId) {
        upiPayment.validateUPI(upiId);
        upiPayment.processPayment(amount, upiId);
    }
    
    // Process Wallet payment
    public void processWalletPayment(double amount, String walletId) {
        walletPayment.checkBalance(walletId);
        walletPayment.processPayment(amount, walletId);
    }
    
    // Process all payment types demo
    public void demonstrateAllPayments() {
        System.out.println("=== Credit Card Payment ===");
        processCreditCardPayment(150.00, "4532015112830366");
        
        System.out.println("=== UPI Payment ===");
        processUPIPayment(75.50, "user@upibank");
        
        System.out.println("=== Wallet Payment ===");
        processWalletPayment(200.00, "WALLET_12345");
    }
}

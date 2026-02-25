// Web platform Wallet Payment implementation
public class WebWalletPayment implements WalletPayment {
    
    @Override
    public void processPayment(double amount, String walletId) {
        System.out.println("[WEB] Processing Wallet payment...");
        System.out.println("[WEB] Connecting to wallet provider via REST API...");
        System.out.println("[WEB] Wallet ID: " + walletId);
        System.out.println("[WEB] Amount: $" + amount + " deducted from web wallet");
        System.out.println("[WEB] Browser notification sent.");
        System.out.println("[WEB] Wallet payment successful!\n");
    }
    
    @Override
    public void checkBalance(String walletId) {
        System.out.println("[WEB] Checking wallet balance via Web dashboard...");
        System.out.println("[WEB] Wallet " + walletId + " balance: $1500.00\n");
    }
}

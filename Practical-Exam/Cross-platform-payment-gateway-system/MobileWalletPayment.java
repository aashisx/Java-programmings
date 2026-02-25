public class MobileWalletPayment implements WalletPayment {
    
    @Override
    public void processPayment(double amount, String walletId) {
        System.out.println("[MOBILE] Processing Wallet payment...");
        System.out.println("[MOBILE] Accessing wallet via Mobile App SDK...");
        System.out.println("[MOBILE] Wallet ID: " + walletId);
        System.out.println("[MOBILE] Fingerprint authentication verified.");
        System.out.println("[MOBILE] Amount: $" + amount + " deducted from mobile wallet");
        System.out.println("[MOBILE] In-app notification displayed.");
        System.out.println("[MOBILE] Wallet payment successful!\n");
    }
    
    @Override
    public void checkBalance(String walletId) {
        System.out.println("[MOBILE] Checking wallet balance via Mobile App...");
        System.out.println("[MOBILE] Wallet " + walletId + " balance: $1500.00\n");
    }
}

// Interface for Wallet Payment
public interface WalletPayment {
    void processPayment(double amount, String walletId);
    void checkBalance(String walletId);
}

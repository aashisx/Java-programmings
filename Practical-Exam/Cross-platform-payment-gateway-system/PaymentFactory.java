public interface PaymentFactory {
    CreditCardPayment createCreditCardPayment();
    UPIPayment createUPIPayment();
    WalletPayment createWalletPayment();
}

public class MobilePaymentFactory implements PaymentFactory {
    
    @Override
    public CreditCardPayment createCreditCardPayment() {
        return new MobileCreditCardPayment();
    }
    
    @Override
    public UPIPayment createUPIPayment() {
        return new MobileUPIPayment();
    }
    
    @Override
    public WalletPayment createWalletPayment() {
        return new MobileWalletPayment();
    }
}

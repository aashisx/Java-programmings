// Concrete Factory for Web Platform
public class WebPaymentFactory implements PaymentFactory {
    
    @Override
    public CreditCardPayment createCreditCardPayment() {
        return new WebCreditCardPayment();
    }
    
    @Override
    public UPIPayment createUPIPayment() {
        return new WebUPIPayment();
    }
    
    @Override
    public WalletPayment createWalletPayment() {
        return new WebWalletPayment();
    }
}

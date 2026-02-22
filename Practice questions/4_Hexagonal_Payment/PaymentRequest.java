// Payment Request - Value Object
public class PaymentRequest {
    private final String orderId;
    private final double amount;
    private final String currency;
    private final String customerEmail;
    
    public PaymentRequest(String orderId, double amount, String currency, String customerEmail) {
        this.orderId = orderId;
        this.amount = amount;
        this.currency = currency;
        this.customerEmail = customerEmail;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public String getCustomerEmail() {
        return customerEmail;
    }
    
    @Override
    public String toString() {
        return "PaymentRequest{orderId='" + orderId + "', amount=" + amount + 
               ", currency='" + currency + "', email='" + customerEmail + "'}";
    }
}

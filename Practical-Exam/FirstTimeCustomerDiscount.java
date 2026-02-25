public class FirstTimeCustomerDiscount implements DiscountStrategy {
    private static final double DISCOUNT_RATE = 0.20;

    @Override
    public double calculateDiscount(double orderAmount) {
        return orderAmount * DISCOUNT_RATE;
    }

    @Override
    public String getDiscountType() {
        return "First Time Customer Discount (20%)";
    }
}

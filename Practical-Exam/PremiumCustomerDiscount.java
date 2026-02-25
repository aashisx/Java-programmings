public class PremiumCustomerDiscount implements DiscountStrategy {
    private static final double DISCOUNT_RATE = 0.15;

    @Override
    public double calculateDiscount(double orderAmount) {
        return orderAmount * DISCOUNT_RATE;
    }

    @Override
    public String getDiscountType() {
        return "Premium Customer Discount (15%)";
    }
}

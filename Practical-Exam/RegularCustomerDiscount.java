public class RegularCustomerDiscount implements DiscountStrategy {
    private static final double DISCOUNT_RATE = 0.05;

    @Override
    public double calculateDiscount(double orderAmount) {
        return orderAmount * DISCOUNT_RATE;
    }

    @Override
    public String getDiscountType() {
        return "Regular Customer Discount (5%)";
    }
}

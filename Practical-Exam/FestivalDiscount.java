
public class FestivalDiscount implements DiscountStrategy {
    private static final double DISCOUNT_RATE = 0.10;
    private static final double MIN_ORDER_AMOUNT = 100.0;

    @Override
    public double calculateDiscount(double orderAmount) {
        if (orderAmount >= MIN_ORDER_AMOUNT) {
            return orderAmount * DISCOUNT_RATE;
        }
        return 0.0;
    }

    @Override
    public String getDiscountType() {
        return "Festival Discount (10% on orders >= 100)";
    }
}

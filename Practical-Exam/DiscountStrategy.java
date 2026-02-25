// Strategy Interface - allows adding new discount rules without modifying existing code
public interface DiscountStrategy {
    double calculateDiscount(double orderAmount);
    String getDiscountType();
}

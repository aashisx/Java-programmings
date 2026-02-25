
public class BillCalculator {
    private DiscountStrategy discountStrategy;

    public BillCalculator() {
       
    }

    public BillCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

   
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public double calculateFinalBill(double orderAmount) {
        if (discountStrategy == null) {
            System.out.println("No discount applied");
            return orderAmount;
        }

        double discount = discountStrategy.calculateDiscount(orderAmount);
        double finalAmount = orderAmount - discount;

        System.out.println("Order Amount: Rs. " + orderAmount);
        System.out.println("Discount Type: " + discountStrategy.getDiscountType());
        System.out.println("Discount Amount: Rs. " + discount);
        System.out.println("Final Payable Amount: Rs. " + finalAmount);
        System.out.println("----------------------------------------");

        return finalAmount;
    }
}

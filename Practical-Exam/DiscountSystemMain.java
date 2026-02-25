
public class DiscountSystemMain {
    public static void main(String[] args) {
        BillCalculator billCalculator = new BillCalculator();

        double orderAmount = 500.0;
        System.out.println("ONLINE FOOD DELIVERY DISCOUNT SYSTEM");
    
        System.out.println("Discount for  Regular Customer:");
        billCalculator.setDiscountStrategy(new RegularCustomerDiscount());
        billCalculator.calculateFinalBill(orderAmount);

        System.out.println("Discount for Premium Customer:");
        billCalculator.setDiscountStrategy(new PremiumCustomerDiscount());
        billCalculator.calculateFinalBill(orderAmount);

 
        System.out.println("Discount for First Time Customer:");
        billCalculator.setDiscountStrategy(new FirstTimeCustomerDiscount());
        billCalculator.calculateFinalBill(orderAmount);

        System.out.println("Discount for Festival:");
        billCalculator.setDiscountStrategy(new FestivalDiscount());
        billCalculator.calculateFinalBill(orderAmount);

        System.out.println("Another  Discount for Regular Customer:");
        billCalculator.setDiscountStrategy(new RegularCustomerDiscount());
        billCalculator.calculateFinalBill(150.0);
        

        System.out.println("Festival Discount with order < 100:");
        billCalculator.calculateFinalBill(80.0);

        System.out.println("No Discount:");
        billCalculator.setDiscountStrategy(null);
        billCalculator.calculateFinalBill(600.0);

    }
}
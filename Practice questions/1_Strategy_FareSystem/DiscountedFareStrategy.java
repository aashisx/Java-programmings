// Discounted Fare Strategy - Discounts based on passenger type
public class DiscountedFareStrategy implements FareStrategy {
    private static final double BASE_RATE = 10.0;
    
    @Override
    public double calculateFare(double distance, String timeOfDay, String passengerType) {
        double fare = distance * BASE_RATE;
        
        // Apply discounts based on passenger type
        switch (passengerType.toUpperCase()) {
            case "STUDENT":
                fare *= 0.5;  // 50% discount
                break;
            case "SENIOR":
                fare *= 0.6;  // 40% discount
                break;
            case "CHILD":
                fare *= 0.25; // 75% discount
                break;
            case "DISABLED":
                fare *= 0.0;  // Free ride
                break;
            default:
                // No discount for regular passengers
                break;
        }
        
        return fare;
    }
    
    @Override
    public String getStrategyName() {
        return "Discounted Fare";
    }
}

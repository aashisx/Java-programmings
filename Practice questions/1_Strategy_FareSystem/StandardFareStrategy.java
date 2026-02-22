// Standard Fare Strategy - Base fare calculation
public class StandardFareStrategy implements FareStrategy {
    private static final double BASE_RATE = 10.0; // Rs. per km
    
    @Override
    public double calculateFare(double distance, String timeOfDay, String passengerType) {
        return distance * BASE_RATE;
    }
    
    @Override
    public String getStrategyName() {
        return "Standard Fare";
    }
}

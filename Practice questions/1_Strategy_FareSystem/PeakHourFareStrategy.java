// Peak Hour Fare Strategy - Higher rates during rush hours
public class PeakHourFareStrategy implements FareStrategy {
    private static final double BASE_RATE = 10.0;
    private static final double PEAK_MULTIPLIER = 1.5;
    
    @Override
    public double calculateFare(double distance, String timeOfDay, String passengerType) {
        double fare = distance * BASE_RATE;
        
        // Peak hours: 8-10 AM and 5-8 PM
        if (timeOfDay.equalsIgnoreCase("PEAK")) {
            fare *= PEAK_MULTIPLIER;
        }
        
        return fare;
    }
    
    @Override
    public String getStrategyName() {
        return "Peak Hour Fare";
    }
}

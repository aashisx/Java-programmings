// Fare Strategy Interface
public interface FareStrategy {
    double calculateFare(double distance, String timeOfDay, String passengerType);
    String getStrategyName();
}

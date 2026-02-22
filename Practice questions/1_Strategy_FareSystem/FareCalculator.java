// Fare Calculator - Context class that uses strategies
public class FareCalculator {
    private FareStrategy fareStrategy;
    
    public FareCalculator(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }
    
    // Switch strategy at runtime (Open-Closed Principle)
    public void setFareStrategy(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }
    
    public FareStrategy getFareStrategy() {
        return fareStrategy;
    }
    
    public double calculateFare(double distance, String timeOfDay, String passengerType) {
        if (fareStrategy == null) {
            throw new IllegalStateException("Fare strategy not set!");
        }
        return fareStrategy.calculateFare(distance, timeOfDay, passengerType);
    }
    
    public void printFareDetails(double distance, String timeOfDay, String passengerType) {
        double fare = calculateFare(distance, timeOfDay, passengerType);
        System.out.println("---------- FARE DETAILS ----------");
        System.out.println("Strategy: " + fareStrategy.getStrategyName());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Time: " + timeOfDay);
        System.out.println("Passenger Type: " + passengerType);
        System.out.println("Total Fare: Rs. " + String.format("%.2f", fare));
        System.out.println("----------------------------------");
    }
}

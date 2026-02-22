// Alert Observer - Triggers alerts based on thresholds
public class AlertObserver implements SensorObserver {
    private final String name;
    private final double threshold;
    private final boolean alertAbove;
    
    public AlertObserver(String name, double threshold, boolean alertAbove) {
        this.name = name;
        this.threshold = threshold;
        this.alertAbove = alertAbove;
    }
    
    @Override
    public void update(String sensorName, double value) {
        if (alertAbove && value > threshold) {
            System.out.println("[ALERT-" + name + "] WARNING! " + sensorName + 
                             " exceeded " + threshold + " (Current: " + value + ")");
        } else if (!alertAbove && value < threshold) {
            System.out.println("[ALERT-" + name + "] WARNING! " + sensorName + 
                             " below " + threshold + " (Current: " + value + ")");
        }
    }
    
    @Override
    public String getObserverName() {
        return "Alert-" + name;
    }
}

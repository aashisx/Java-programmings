// Display Observer - Shows sensor data on screen
public class DisplayObserver implements SensorObserver {
    private final String name;
    
    public DisplayObserver(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String sensorName, double value) {
        System.out.println("[DISPLAY-" + name + "] " + sensorName + " = " + value);
    }
    
    @Override
    public String getObserverName() {
        return "Display-" + name;
    }
}

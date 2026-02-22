import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

// Logger Observer - Logs sensor data with timestamps
public class LoggerObserver implements SensorObserver {
    private final String name;
    private final Map<String, Double> lastValues;
    
    public LoggerObserver(String name) {
        this.name = name;
        this.lastValues = new ConcurrentHashMap<>();
    }
    
    @Override
    public void update(String sensorName, double value) {
        Double lastValue = lastValues.get(sensorName);
        String change = "";
        if (lastValue != null) {
            double diff = value - lastValue;
            change = (diff >= 0 ? " (+" : " (") + String.format("%.2f", diff) + ")";
        }
        lastValues.put(sensorName, value);
        
        System.out.println("[LOG-" + name + "] [" + System.currentTimeMillis() + "] " + 
                          sensorName + ": " + value + change);
    }
    
    @Override
    public String getObserverName() {
        return "Logger-" + name;
    }
}

// Observer Interface
public interface SensorObserver {
    void update(String sensorName, double value);
    String getObserverName();
}

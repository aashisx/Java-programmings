// Subject Interface
public interface SensorSubject {
    void registerObserver(SensorObserver observer);
    void removeObserver(SensorObserver observer);
    void notifyObservers();
}

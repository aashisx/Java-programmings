import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Thread-Safe Sensor Implementation
public class Sensor implements SensorSubject, Runnable {
    private final String sensorName;
    private volatile double currentValue;
    private final List<SensorObserver> observers;
    private final ReadWriteLock lock;
    private volatile boolean running;
    private final double minValue;
    private final double maxValue;
    
    public Sensor(String sensorName, double minValue, double maxValue) {
        this.sensorName = sensorName;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.currentValue = minValue;
        // CopyOnWriteArrayList for thread-safe iteration
        this.observers = new CopyOnWriteArrayList<>();
        this.lock = new ReentrantReadWriteLock();
        this.running = false;
    }
    
    @Override
    public void registerObserver(SensorObserver observer) {
        lock.writeLock().lock();
        try {
            if (!observers.contains(observer)) {
                observers.add(observer);
                System.out.println("[" + sensorName + "] Observer registered: " + observer.getObserverName());
            }
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    @Override
    public void removeObserver(SensorObserver observer) {
        lock.writeLock().lock();
        try {
            observers.remove(observer);
            System.out.println("[" + sensorName + "] Observer removed: " + observer.getObserverName());
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    @Override
    public void notifyObservers() {
        lock.readLock().lock();
        try {
            double valueSnapshot = currentValue;
            for (SensorObserver observer : observers) {
                observer.update(sensorName, valueSnapshot);
            }
        } finally {
            lock.readLock().unlock();
        }
    }
    
    public void updateValue(double newValue) {
        lock.writeLock().lock();
        try {
            this.currentValue = newValue;
        } finally {
            lock.writeLock().unlock();
        }
        notifyObservers();
    }
    
    public double getCurrentValue() {
        lock.readLock().lock();
        try {
            return currentValue;
        } finally {
            lock.readLock().unlock();
        }
    }
    
    public String getSensorName() {
        return sensorName;
    }
    
    public void start() {
        running = true;
        new Thread(this, sensorName + "-Thread").start();
    }
    
    public void stop() {
        running = false;
    }
    
    @Override
    public void run() {
        System.out.println("[" + sensorName + "] Sensor started");
        while (running) {
            try {
                // Simulate sensor reading with random value
                double newValue = minValue + Math.random() * (maxValue - minValue);
                updateValue(Math.round(newValue * 100.0) / 100.0);
                Thread.sleep(1000 + (int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("[" + sensorName + "] Sensor stopped");
    }
}

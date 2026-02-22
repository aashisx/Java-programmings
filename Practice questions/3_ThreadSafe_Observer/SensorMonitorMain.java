// Main class demonstrating Thread-Safe Observer Pattern
public class SensorMonitorMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=============================================");
        System.out.println("   REAL-TIME SENSOR MONITORING SYSTEM");
        System.out.println("   (Thread-Safe Observer Pattern)");
        System.out.println("=============================================\n");
        
        // Create sensors (Subject)
        Sensor temperatureSensor = new Sensor("Temperature", 20.0, 45.0);
        Sensor humiditySensor = new Sensor("Humidity", 30.0, 90.0);
        Sensor pressureSensor = new Sensor("Pressure", 980.0, 1050.0);
        
        // Create observers
        DisplayObserver mainDisplay = new DisplayObserver("Main");
        AlertObserver tempAlert = new AlertObserver("TempHigh", 40.0, true);
        AlertObserver humidityAlert = new AlertObserver("HumidityLow", 40.0, false);
        LoggerObserver dataLogger = new LoggerObserver("System");
        
        System.out.println("--- Registering Observers ---\n");
        
        // Register observers with sensors
        temperatureSensor.registerObserver(mainDisplay);
        temperatureSensor.registerObserver(tempAlert);
        temperatureSensor.registerObserver(dataLogger);
        
        humiditySensor.registerObserver(mainDisplay);
        humiditySensor.registerObserver(humidityAlert);
        humiditySensor.registerObserver(dataLogger);
        
        pressureSensor.registerObserver(mainDisplay);
        pressureSensor.registerObserver(dataLogger);
        
        System.out.println("\n--- Starting Sensors (Concurrent Updates) ---\n");
        
        // Start sensors (each runs in its own thread)
        temperatureSensor.start();
        humiditySensor.start();
        pressureSensor.start();
        
        // Let sensors run for a while
        Thread.sleep(8000);
        
        System.out.println("\n--- Dynamic Observer Management ---\n");
        
        // Demonstrate removing observer at runtime
        temperatureSensor.removeObserver(mainDisplay);
        
        // Add new observer at runtime
        DisplayObserver secondaryDisplay = new DisplayObserver("Secondary");
        temperatureSensor.registerObserver(secondaryDisplay);
        
        // Let sensors run a bit more
        Thread.sleep(4000);
        
        System.out.println("\n--- Stopping Sensors ---\n");
        
        // Stop all sensors
        temperatureSensor.stop();
        humiditySensor.stop();
        pressureSensor.stop();
        
        // Wait for threads to finish
        Thread.sleep(2000);
        
        System.out.println("\n=============================================");
        System.out.println("Thread-Safe Features Demonstrated:");
        System.out.println("- CopyOnWriteArrayList for thread-safe observer list");
        System.out.println("- ReadWriteLock for concurrent read/write access");
        System.out.println("- volatile keyword for visibility guarantees");
        System.out.println("- Concurrent observer registration/removal");
        System.out.println("=============================================");
    }
}

// Car class - Owns and manages Engine (Composition)
// Engine cannot exist without Car
public class Car {
    private final String carId;
    private final String brand;
    private final String model;
    private final int year;
    private final Engine engine; // Composition - Engine is part of Car
    private boolean engineStarted;
    private int speed;
    
    // Car creates its own Engine - Engine lifetime tied to Car
    public Car(String carId, String brand, String model, int year,
               String engineType, int horsepower, double displacement) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineStarted = false;
        this.speed = 0;
        
        System.out.println("[CAR] Creating " + brand + " " + model + "...");
        
        // Engine is created BY the Car, FOR the Car
        // Engine ID is derived from Car ID
        String engineId = "ENG-" + carId;
        this.engine = new Engine(engineId, engineType, horsepower, displacement);
        
        System.out.println("[CAR] " + brand + " " + model + " ready!");
    }
    
    // Public interface to control the car (not direct engine access)
    public void startCar() {
        System.out.println("\n[CAR] Starting " + brand + " " + model + "...");
        engine.start();
        engineStarted = engine.isRunning();
        if (engineStarted) {
            System.out.println("[CAR] Car started successfully!");
        }
    }
    
    public void stopCar() {
        System.out.println("\n[CAR] Stopping " + brand + " " + model + "...");
        if (speed > 0) {
            System.out.println("[CAR] Slowing down first...");
            speed = 0;
        }
        engine.stop();
        engineStarted = false;
        System.out.println("[CAR] Car stopped.");
    }
    
    public void accelerate() {
        if (!engineStarted) {
            System.out.println("\n[CAR] Cannot accelerate - start the car first!");
            return;
        }
        System.out.println("\n[CAR] Accelerating...");
        engine.accelerate(500);
        speed = calculateSpeed(engine.getRpm());
        System.out.println("[CAR] Current speed: " + speed + " km/h");
    }
    
    public void brake() {
        if (speed == 0) {
            System.out.println("\n[CAR] Already stopped.");
            return;
        }
        System.out.println("\n[CAR] Braking...");
        engine.decelerate(300);
        speed = calculateSpeed(engine.getRpm());
        System.out.println("[CAR] Current speed: " + speed + " km/h");
    }
    
    // Engine access is controlled - only read-only info exposed
    public String getEngineInfo() {
        // Return a copy of engine info, not the engine itself
        return String.format(
            "Engine Type: %s, Horsepower: %d HP, Displacement: %.1f L, Status: %s",
            engine.getType(),
            engine.getHorsepower(),
            engine.getDisplacement(),
            engine.isRunning() ? "Running at " + engine.getRpm() + " RPM" : "Off"
        );
    }
    
    // NO method to get the Engine object directly
    // This prevents external code from manipulating the engine
    
    private int calculateSpeed(int rpm) {
        // Simple speed calculation based on RPM
        return (int) ((rpm - 800) * 0.03);
    }
    
    public void displayStatus() {
        System.out.println("\n========== CAR STATUS ==========");
        System.out.println("Car: " + brand + " " + model + " (" + year + ")");
        System.out.println("ID: " + carId);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Engine Started: " + (engineStarted ? "Yes" : "No"));
        System.out.println("Engine: " + getEngineInfo());
        System.out.println("=================================");
    }
    
    // Getters for car info
    public String getCarId() {
        return carId;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getYear() {
        return year;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public boolean isEngineStarted() {
        return engineStarted;
    }
    
    @Override
    public String toString() {
        return String.format("Car[%s %s %d, %s]", 
            brand, model, year, engineStarted ? "Running" : "Off");
    }
}

// Engine class - Can only exist as part of a Car
// Package-private class - cannot be instantiated from outside package directly
class Engine {
    private final String engineId;
    private final String type;
    private final int horsepower;
    private final double displacement; // in liters
    private boolean running;
    private int rpm;
    
    // Package-private constructor - only Car can create Engine
    Engine(String engineId, String type, int horsepower, double displacement) {
        this.engineId = engineId;
        this.type = type;
        this.horsepower = horsepower;
        this.displacement = displacement;
        this.running = false;
        this.rpm = 0;
        System.out.println("  [ENGINE] Created: " + type + " (" + horsepower + " HP)");
    }
    
    // Package-private methods - only Car can control Engine
    void start() {
        if (running) {
            System.out.println("  [ENGINE] Already running");
            return;
        }
        running = true;
        rpm = 800; // idle RPM
        System.out.println("  [ENGINE] Started. RPM: " + rpm);
    }
    
    void stop() {
        if (!running) {
            System.out.println("  [ENGINE] Already stopped");
            return;
        }
        running = false;
        rpm = 0;
        System.out.println("  [ENGINE] Stopped");
    }
    
    void accelerate(int rpmIncrease) {
        if (!running) {
            System.out.println("  [ENGINE] Cannot accelerate - engine not running");
            return;
        }
        rpm = Math.min(rpm + rpmIncrease, 8000); // Max RPM limit
        System.out.println("  [ENGINE] Accelerating. RPM: " + rpm);
    }
    
    void decelerate(int rpmDecrease) {
        if (!running) {
            return;
        }
        rpm = Math.max(rpm - rpmDecrease, 800); // Min idle RPM
        System.out.println("  [ENGINE] Decelerating. RPM: " + rpm);
    }
    
    boolean isRunning() {
        return running;
    }
    
    int getRpm() {
        return rpm;
    }
    
    // Read-only access for status display
    String getEngineId() {
        return engineId;
    }
    
    String getType() {
        return type;
    }
    
    int getHorsepower() {
        return horsepower;
    }
    
    double getDisplacement() {
        return displacement;
    }
    
    @Override
    public String toString() {
        return String.format("Engine[%s, %s, %dHP, %.1fL, %s, %dRPM]",
            engineId, type, horsepower, displacement,
            running ? "RUNNING" : "OFF", rpm);
    }
}

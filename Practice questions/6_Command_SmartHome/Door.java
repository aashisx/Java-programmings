// Door - Receiver class
public class Door {
    private final String location;
    private boolean isOpen;
    private boolean isLocked;
    
    public Door(String location) {
        this.location = location;
        this.isOpen = false;
        this.isLocked = true;
    }
    
    public void open() {
        if (isLocked) {
            System.out.println("[DOOR] " + location + " door is locked! Unlocking first...");
            unlock();
        }
        isOpen = true;
        System.out.println("[DOOR] " + location + " door OPENED");
    }
    
    public void close() {
        isOpen = false;
        System.out.println("[DOOR] " + location + " door CLOSED");
    }
    
    public void lock() {
        if (isOpen) {
            System.out.println("[DOOR] Cannot lock " + location + " door - it's open!");
            return;
        }
        isLocked = true;
        System.out.println("[DOOR] " + location + " door LOCKED");
    }
    
    public void unlock() {
        isLocked = false;
        System.out.println("[DOOR] " + location + " door UNLOCKED");
    }
    
    public boolean isOpen() {
        return isOpen;
    }
    
    public boolean isLocked() {
        return isLocked;
    }
    
    public String getLocation() {
        return location;
    }
    
    @Override
    public String toString() {
        return "Door{" + location + ", " + (isOpen ? "OPEN" : "CLOSED") + 
               ", " + (isLocked ? "LOCKED" : "UNLOCKED") + "}";
    }
}

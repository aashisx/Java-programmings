// Light - Receiver class
public class Light {
    private final String location;
    private boolean isOn;
    private int brightness; // 0-100
    
    public Light(String location) {
        this.location = location;
        this.isOn = false;
        this.brightness = 100;
    }
    
    public void turnOn() {
        isOn = true;
        System.out.println("[LIGHT] " + location + " light turned ON (brightness: " + brightness + "%)");
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println("[LIGHT] " + location + " light turned OFF");
    }
    
    public boolean isOn() {
        return isOn;
    }
    
    public String getLocation() {
        return location;
    }
    
    public int getBrightness() {
        return brightness;
    }
    
    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
    
    @Override
    public String toString() {
        return "Light{" + location + ", " + (isOn ? "ON" : "OFF") + ", " + brightness + "%}";
    }
}

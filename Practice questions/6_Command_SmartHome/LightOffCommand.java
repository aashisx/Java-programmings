// Light Off Command
public class LightOffCommand implements Command {
    private final Light light;
    private boolean wasOn;
    
    public LightOffCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        wasOn = light.isOn();
        light.turnOff();
    }
    
    @Override
    public void undo() {
        if (wasOn) {
            light.turnOn();
            System.out.println("[UNDO] Light " + light.getLocation() + " turned back ON");
        }
    }
    
    @Override
    public String getDescription() {
        return "Turn OFF " + light.getLocation() + " Light";
    }
}

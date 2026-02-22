// Light On Command
public class LightOnCommand implements Command {
    private final Light light;
    private boolean wasOn;
    
    public LightOnCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        wasOn = light.isOn();
        light.turnOn();
    }
    
    @Override
    public void undo() {
        if (!wasOn) {
            light.turnOff();
            System.out.println("[UNDO] Light " + light.getLocation() + " turned back OFF");
        }
    }
    
    @Override
    public String getDescription() {
        return "Turn ON " + light.getLocation() + " Light";
    }
}

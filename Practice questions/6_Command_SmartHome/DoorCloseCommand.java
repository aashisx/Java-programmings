// Door Close Command
public class DoorCloseCommand implements Command {
    private final Door door;
    private boolean wasOpen;
    
    public DoorCloseCommand(Door door) {
        this.door = door;
    }
    
    @Override
    public void execute() {
        wasOpen = door.isOpen();
        door.close();
    }
    
    @Override
    public void undo() {
        if (wasOpen) {
            door.open();
            System.out.println("[UNDO] Door " + door.getLocation() + " opened back");
        }
    }
    
    @Override
    public String getDescription() {
        return "Close " + door.getLocation() + " Door";
    }
}

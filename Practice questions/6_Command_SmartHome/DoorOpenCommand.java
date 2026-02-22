// Door Open Command
public class DoorOpenCommand implements Command {
    private final Door door;
    private boolean wasOpen;
    private boolean wasLocked;
    
    public DoorOpenCommand(Door door) {
        this.door = door;
    }
    
    @Override
    public void execute() {
        wasOpen = door.isOpen();
        wasLocked = door.isLocked();
        door.open();
    }
    
    @Override
    public void undo() {
        if (!wasOpen) {
            door.close();
            if (wasLocked) {
                door.lock();
            }
            System.out.println("[UNDO] Door " + door.getLocation() + " restored to previous state");
        }
    }
    
    @Override
    public String getDescription() {
        return "Open " + door.getLocation() + " Door";
    }
}

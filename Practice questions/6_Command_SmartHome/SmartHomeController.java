import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

// Smart Home Controller - Invoker with Undo/Redo support
public class SmartHomeController {
    private final Stack<Command> undoStack;
    private final Stack<Command> redoStack;
    private final List<Command> commandHistory;
    
    public SmartHomeController() {
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
        this.commandHistory = new ArrayList<>();
    }
    
    public void executeCommand(Command command) {
        System.out.println("\n[EXECUTE] " + command.getDescription());
        command.execute();
        undoStack.push(command);
        redoStack.clear(); // Clear redo stack after new command
        commandHistory.add(command);
    }
    
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("\n[UNDO] Nothing to undo!");
            return;
        }
        
        Command command = undoStack.pop();
        System.out.println("\n[UNDO] Undoing: " + command.getDescription());
        command.undo();
        redoStack.push(command);
    }
    
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("\n[REDO] Nothing to redo!");
            return;
        }
        
        Command command = redoStack.pop();
        System.out.println("\n[REDO] Redoing: " + command.getDescription());
        command.execute();
        undoStack.push(command);
    }
    
    public void printStatus() {
        System.out.println("\n--- Controller Status ---");
        System.out.println("Commands in undo stack: " + undoStack.size());
        System.out.println("Commands in redo stack: " + redoStack.size());
        System.out.println("Total commands executed: " + commandHistory.size());
    }
    
    public void printHistory() {
        System.out.println("\n--- Command History ---");
        if (commandHistory.isEmpty()) {
            System.out.println("No commands executed yet.");
            return;
        }
        for (int i = 0; i < commandHistory.size(); i++) {
            System.out.println((i + 1) + ". " + commandHistory.get(i).getDescription());
        }
    }
    
    public int getUndoStackSize() {
        return undoStack.size();
    }
    
    public int getRedoStackSize() {
        return redoStack.size();
    }
}

// Command Interface with execute, undo and redo support
public interface Command {
    void execute();
    void undo();
    String getDescription();
}

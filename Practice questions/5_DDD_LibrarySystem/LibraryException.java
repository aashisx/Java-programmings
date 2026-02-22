// Custom exception for library business rule violations
public class LibraryException extends RuntimeException {
    public LibraryException(String message) {
        super(message);
    }
}

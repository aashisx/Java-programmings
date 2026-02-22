// Book Entity - Cannot be modified directly from outside
// Part of Library Aggregate
public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private boolean available;
    private String borrowedByMemberId;
    
    // Package-private constructor - only Library can create books
    Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
        this.borrowedByMemberId = null;
    }
    
    // Package-private - only Library (aggregate root) can modify
    void markAsBorrowed(String memberId) {
        this.available = false;
        this.borrowedByMemberId = memberId;
    }
    
    // Package-private - only Library (aggregate root) can modify
    void markAsReturned() {
        this.available = true;
        this.borrowedByMemberId = null;
    }
    
    // Public getters - read-only access
    public String getIsbn() {
        return isbn;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public String getBorrowedByMemberId() {
        return borrowedByMemberId;
    }
    
    @Override
    public String toString() {
        return "Book{isbn='" + isbn + "', title='" + title + "', author='" + author + 
               "', available=" + available + "}";
    }
}

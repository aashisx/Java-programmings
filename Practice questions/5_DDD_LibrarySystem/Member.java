import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Member Entity - Cannot be modified directly from outside
// Part of Library Aggregate
public class Member {
    private final String memberId;
    private final String name;
    private final String email;
    private final List<String> borrowedBookIsbns;
    private static final int MAX_BOOKS = 3;
    
    // Package-private constructor - only Library can create members
    Member(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.borrowedBookIsbns = new ArrayList<>();
    }
    
    // Package-private - only Library (aggregate root) can modify
    void addBorrowedBook(String isbn) {
        borrowedBookIsbns.add(isbn);
    }
    
    // Package-private - only Library (aggregate root) can modify
    void removeBorrowedBook(String isbn) {
        borrowedBookIsbns.remove(isbn);
    }
    
    // Package-private - for aggregate root to check rules
    boolean canBorrowMore() {
        return borrowedBookIsbns.size() < MAX_BOOKS;
    }
    
    // Package-private - for aggregate root to check rules
    boolean hasBorrowed(String isbn) {
        return borrowedBookIsbns.contains(isbn);
    }
    
    // Public getters - read-only access
    public String getMemberId() {
        return memberId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public List<String> getBorrowedBookIsbns() {
        // Return unmodifiable list to prevent external modification
        return Collections.unmodifiableList(borrowedBookIsbns);
    }
    
    public int getBorrowedCount() {
        return borrowedBookIsbns.size();
    }
    
    public int getRemainingBorrowLimit() {
        return MAX_BOOKS - borrowedBookIsbns.size();
    }
    
    @Override
    public String toString() {
        return "Member{id='" + memberId + "', name='" + name + 
               "', borrowedBooks=" + borrowedBookIsbns.size() + "/" + MAX_BOOKS + "}";
    }
}

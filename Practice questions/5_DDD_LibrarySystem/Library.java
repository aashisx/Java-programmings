import java.util.HashMap;
import java.util.Map;
import java.util.Collections;


public class Library {
    private final String libraryId;
    private final String name;
    private final Map<String, Book> books;
    private final Map<String, Member> members;
    
    public Library(String libraryId, String name) {
        this.libraryId = libraryId;
        this.name = name;
        this.books = new HashMap<>();
        this.members = new HashMap<>();
    }
    
    // ========== Book Management ==========
    
    public void addBook(String isbn, String title, String author) {
        if (books.containsKey(isbn)) {
            throw new LibraryException("Book with ISBN " + isbn + " already exists");
        }
        Book book = new Book(isbn, title, author);
        books.put(isbn, book);
        System.out.println("[LIBRARY] Book added: " + title);
    }
    
    public Book getBook(String isbn) {
        return books.get(isbn);
    }
    
    public Map<String, Book> getAllBooks() {
        return Collections.unmodifiableMap(books);
    }
    
    // ========== Member Management ==========
    
    public void registerMember(String memberId, String name, String email) {
        if (members.containsKey(memberId)) {
            throw new LibraryException("Member with ID " + memberId + " already exists");
        }
        Member member = new Member(memberId, name, email);
        members.put(memberId, member);
        System.out.println("[LIBRARY] Member registered: " + name);
    }
    
    public Member getMember(String memberId) {
        return members.get(memberId);
    }
    
    public Map<String, Member> getAllMembers() {
        return Collections.unmodifiableMap(members);
    }
    
    // ========== Borrowing Operations (Business Rules Enforced) ==========
    
    public void borrowBook(String memberId, String isbn) {
        // Validate member exists
        Member member = members.get(memberId);
        if (member == null) {
            throw new LibraryException("Member not found: " + memberId);
        }
        
        // Validate book exists
        Book book = books.get(isbn);
        if (book == null) {
            throw new LibraryException("Book not found: " + isbn);
        }
        
        // BUSINESS RULE 1: Max 3 books per member
        if (!member.canBorrowMore()) {
            throw new LibraryException("Member has reached maximum borrowing limit (3 books)");
        }
        
        // BUSINESS RULE 2: No duplicate borrowing
        if (member.hasBorrowed(isbn)) {
            throw new LibraryException("Member has already borrowed this book");
        }
        
        // BUSINESS RULE 3: Book must be available
        if (!book.isAvailable()) {
            throw new LibraryException("Book is not available (borrowed by another member)");
        }
        
        // All rules passed - perform the borrow operation
        // Only aggregate root (Library) modifies entities
        book.markAsBorrowed(memberId);
        member.addBorrowedBook(isbn);
        
        System.out.println("[LIBRARY] Book borrowed successfully!");
        System.out.println("  Member: " + member.getName());
        System.out.println("  Book: " + book.getTitle());
        System.out.println("  Remaining limit: " + member.getRemainingBorrowLimit() + " books");
    }
    
    public void returnBook(String memberId, String isbn) {
        // Validate member exists
        Member member = members.get(memberId);
        if (member == null) {
            throw new LibraryException("Member not found: " + memberId);
        }
        
        // Validate book exists
        Book book = books.get(isbn);
        if (book == null) {
            throw new LibraryException("Book not found: " + isbn);
        }
        
        // Validate member has this book
        if (!member.hasBorrowed(isbn)) {
            throw new LibraryException("Member has not borrowed this book");
        }
        
        // Validate book is borrowed by this member
        if (!memberId.equals(book.getBorrowedByMemberId())) {
            throw new LibraryException("Book is not borrowed by this member");
        }
        
        // Perform return operation
        book.markAsReturned();
        member.removeBorrowedBook(isbn);
        
        System.out.println("[LIBRARY] Book returned successfully!");
        System.out.println("  Member: " + member.getName());
        System.out.println("  Book: " + book.getTitle());
    }
    
    // ========== Information Methods ==========
    
    public void printLibraryStatus() {
        System.out.println("\n========== LIBRARY STATUS ==========");
        System.out.println("Library: " + name + " (" + libraryId + ")");
        System.out.println("Total Books: " + books.size());
        System.out.println("Total Members: " + members.size());
        
        long availableBooks = books.values().stream().filter(Book::isAvailable).count();
        System.out.println("Available Books: " + availableBooks);
        System.out.println("Borrowed Books: " + (books.size() - availableBooks));
        System.out.println("=====================================");
    }
    
    public String getLibraryId() {
        return libraryId;
    }
    
    public String getName() {
        return name;
    }
}

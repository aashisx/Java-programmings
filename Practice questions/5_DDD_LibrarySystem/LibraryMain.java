import java.util.Scanner;

// Main class demonstrating Domain Model with Aggregates (DDD Style)
public class LibraryMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=============================================");
        System.out.println("   LIBRARY BORROWING SYSTEM");
        System.out.println("   (Domain-Driven Design - Aggregates)");
        System.out.println("=============================================\n");
        
        // Create Library (Aggregate Root)
        Library library = new Library("LIB-001", "City Central Library");
        
        // Add some books
        library.addBook("ISBN-001", "Clean Code", "Robert C. Martin");
        library.addBook("ISBN-002", "Design Patterns", "Gang of Four");
        library.addBook("ISBN-003", "Domain-Driven Design", "Eric Evans");
        library.addBook("ISBN-004", "Refactoring", "Martin Fowler");
        library.addBook("ISBN-005", "The Pragmatic Programmer", "Dave Thomas");
        
        // Register members
        library.registerMember("MEM-001", "Alice Johnson", "alice@example.com");
        library.registerMember("MEM-002", "Bob Smith", "bob@example.com");
        
        while (true) {
            System.out.println("\n--- Library Operations ---");
            System.out.println("1. Borrow a Book");
            System.out.println("2. Return a Book");
            System.out.println("3. View Library Status");
            System.out.println("4. View Member Details");
            System.out.println("5. View Book Details");
            System.out.println("6. Demonstrate Business Rules");
            System.out.println("7. EXIT");
            System.out.print("Choice: ");
            
            String choice = scanner.nextLine().trim();
            
            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter Member ID (MEM-001/MEM-002): ");
                        String borrowMemberId = scanner.nextLine().trim();
                        System.out.print("Enter Book ISBN (ISBN-001 to ISBN-005): ");
                        String borrowIsbn = scanner.nextLine().trim();
                        library.borrowBook(borrowMemberId, borrowIsbn);
                        break;
                        
                    case "2":
                        System.out.print("Enter Member ID: ");
                        String returnMemberId = scanner.nextLine().trim();
                        System.out.print("Enter Book ISBN: ");
                        String returnIsbn = scanner.nextLine().trim();
                        library.returnBook(returnMemberId, returnIsbn);
                        break;
                        
                    case "3":
                        library.printLibraryStatus();
                        break;
                        
                    case "4":
                        System.out.print("Enter Member ID: ");
                        String viewMemberId = scanner.nextLine().trim();
                        Member member = library.getMember(viewMemberId);
                        if (member != null) {
                            System.out.println("\n" + member);
                            System.out.println("Borrowed Books: " + member.getBorrowedBookIsbns());
                        } else {
                            System.out.println("Member not found!");
                        }
                        break;
                        
                    case "5":
                        System.out.print("Enter Book ISBN: ");
                        String viewIsbn = scanner.nextLine().trim();
                        Book book = library.getBook(viewIsbn);
                        if (book != null) {
                            System.out.println("\n" + book);
                        } else {
                            System.out.println("Book not found!");
                        }
                        break;
                        
                    case "6":
                        demonstrateBusinessRules(library);
                        break;
                        
                    case "7":
                        System.out.println("Thank you for using Library System!");
                        scanner.close();
                        return;
                        
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (LibraryException e) {
                System.out.println("\n[ERROR] " + e.getMessage());
            }
        }
    }
    
    private static void demonstrateBusinessRules(Library library) {
        System.out.println("\n============================================");
        System.out.println("DEMONSTRATING DDD BUSINESS RULES");
        System.out.println("============================================");
        
        // Reset library state for demo
        Library demoLibrary = new Library("DEMO-001", "Demo Library");
        demoLibrary.addBook("B1", "Book One", "Author A");
        demoLibrary.addBook("B2", "Book Two", "Author B");
        demoLibrary.addBook("B3", "Book Three", "Author C");
        demoLibrary.addBook("B4", "Book Four", "Author D");
        demoLibrary.registerMember("M1", "Test Member", "test@example.com");
        
        System.out.println("\n--- RULE 1: Max 3 books per member ---");
        try {
            demoLibrary.borrowBook("M1", "B1");
            demoLibrary.borrowBook("M1", "B2");
            demoLibrary.borrowBook("M1", "B3");
            System.out.println("Attempting to borrow 4th book...");
            demoLibrary.borrowBook("M1", "B4"); // Should fail
        } catch (LibraryException e) {
            System.out.println("[RULE ENFORCED] " + e.getMessage());
        }
        
        // Return a book for next demo
        demoLibrary.returnBook("M1", "B1");
        
        System.out.println("\n--- RULE 2: No duplicate borrowing ---");
        try {
            System.out.println("Attempting to borrow same book twice...");
            demoLibrary.borrowBook("M1", "B2"); // Already borrowed
        } catch (LibraryException e) {
            System.out.println("[RULE ENFORCED] " + e.getMessage());
        }
        
        System.out.println("\n--- RULE 3: Cannot modify entities directly ---");
        System.out.println("Book and Member classes have package-private setters.");
        System.out.println("Only Library (Aggregate Root) can modify them.");
        System.out.println("External code gets read-only views via getters.");
        
        System.out.println("\n============================================");
        System.out.println("KEY DDD CONCEPTS DEMONSTRATED:");
        System.out.println("- Library is the Aggregate Root");
        System.out.println("- Book and Member are Entities within aggregate");
        System.out.println("- Business invariants enforced by aggregate root");
        System.out.println("- External code cannot create illegal state");
        System.out.println("============================================");
    }
}

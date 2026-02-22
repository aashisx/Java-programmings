import java.util.Scanner;

// Main class to test the Factory Design Pattern
public class TicketMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketFactory ticketFactory = new TicketFactory();
        
        System.out.println("========================================");
        System.out.println("   TRANSPORTATION TICKET GENERATOR");
        System.out.println("========================================");
        
        while (true) {
            System.out.println("\nAvailable Ticket Types:");
            System.out.println("1. BUS");
            System.out.println("2. TRAIN");
            System.out.println("3. FLIGHT");
            System.out.println("4. EXIT");
            System.out.print("\nEnter your choice (BUS/TRAIN/FLIGHT/EXIT): ");
            
            String choice = scanner.nextLine().trim();
            
            if (choice.equalsIgnoreCase("EXIT") || choice.equals("4")) {
                System.out.println("Thank you for using Transportation Ticket Generator!");
                break;
            }
            
           
            Ticket ticket = ticketFactory.createTicket(choice);
            
            if (ticket != null) {
                System.out.println("\n*** Ticket Generated Successfully! ***\n");
                ticket.printTicket();
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
        
        scanner.close();
    }
}

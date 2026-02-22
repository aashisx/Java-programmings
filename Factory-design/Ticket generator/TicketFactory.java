// Factory class to create Ticket objects
public class TicketFactory {
    
    // Factory method to create tickets based on type
    public Ticket createTicket(String ticketType) {
        if (ticketType == null || ticketType.isEmpty()) {
            return null;
        }
        
        switch (ticketType.toUpperCase()) {
            case "BUS":
                return new BusTicket();
            case "TRAIN":
                return new TrainTicket();
            case "FLIGHT":
                return new FlightTicket();
            default:
                System.out.println("Unknown ticket type: " + ticketType);
                return null;
        }
    }
}

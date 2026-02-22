// Concrete class for Flight Ticket
public class FlightTicket implements Ticket {
    private String source;
    private String destination;
    private double price;
    private String flightNumber;
    private String airline;

    public FlightTicket() {
        this.source = "Tribhuvan International Airport";
        this.destination = "Delhi International Airport";
        this.price = 15000.00;
        this.flightNumber = "AI-202";
        this.airline = "Air India";
    }

    @Override
    public void printTicket() {
        System.out.println("========== FLIGHT TICKET ==========");
        System.out.println("Type: " + getTicketType());
        System.out.println("Airline: " + airline);
        System.out.println("Flight No: " + flightNumber);
        System.out.println("From: " + source);
        System.out.println("To: " + destination);
        System.out.println("Price: Rs. " + price);
        System.out.println("====================================");
    }

    @Override
    public String getTicketType() {
        return "FLIGHT";
    }

    @Override
    public double getPrice() {
        return price;
    }
}

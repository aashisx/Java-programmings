// Concrete class for Bus Ticket
public class BusTicket implements Ticket {
    private String source;
    private String destination;
    private double price;

    public BusTicket() {
        this.source = "City Terminal";
        this.destination = "Town Station";
        this.price = 150.00;
    }

    @Override
    public void printTicket() {
        System.out.println("========== BUS TICKET ==========");
        System.out.println("Type: " + getTicketType());
        System.out.println("From: " + source);
        System.out.println("To: " + destination);
        System.out.println("Price: Rs. " + price);
        System.out.println("================================");
    }

    @Override
    public String getTicketType() {
        return "BUS";
    }

    @Override
    public double getPrice() {
        return price;
    }
}

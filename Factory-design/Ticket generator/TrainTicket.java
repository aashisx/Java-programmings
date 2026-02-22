
public class TrainTicket implements Ticket {
    private String source;
    private String destination;
    private double price;
    private String trainNumber;

    public TrainTicket() {
        this.source = "Central Railway Station";
        this.destination = "Junction Station";
        this.price = 350.00;
        this.trainNumber = "EXP-1234";
    }

    @Override
    public void printTicket() {
        System.out.println("========== TRAIN TICKET ==========");
        System.out.println("Type: " + getTicketType());
        System.out.println("Train No: " + trainNumber);
        System.out.println("From: " + source);
        System.out.println("To: " + destination);
        System.out.println("Price: Rs. " + price);
        System.out.println("==================================");
    }

    @Override
    public String getTicketType() {
        return "TRAIN";
    }

    @Override
    public double getPrice() {
        return price;
    }
}

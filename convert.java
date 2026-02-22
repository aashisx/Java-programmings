import java.util.Scanner;
public class convert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Enter a string of number: ");
            String input = scanner.nextLine();
            int number = Integer.parseInt(input);
            System.out.println("The string converted to integer is: " + number);
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}

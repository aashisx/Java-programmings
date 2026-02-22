import java.util.Scanner;

// Main class to test the Factory Design Pattern
public class EncryptionMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EncryptionFactory encryptionFactory = new EncryptionFactory();
        
        System.out.println("==========================================");
        System.out.println("   MESSAGE ENCRYPTION FACTORY");
        System.out.println("==========================================");
        
        while (true) {
            System.out.println("\nAvailable Encryption Types:");
            System.out.println("1. AES");
            System.out.println("2. DES");
            System.out.println("3. BASE64");
            System.out.println("4. EXIT");
            System.out.print("\nEnter encryption type (AES/DES/BASE64/EXIT): ");
            
            String choice = scanner.nextLine().trim();
            
            if (choice.equalsIgnoreCase("EXIT") || choice.equals("4")) {
                System.out.println("Thank you for using Message Encryption Factory!");
                break;
            }
            
            // Use factory to create encryption
            Encryption encryption = encryptionFactory.createEncryption(choice);
            
            if (encryption != null) {
                System.out.println("\n*** " + encryption.getEncryptionType() + " Encryption Selected ***");
                
                System.out.print("Enter message to encrypt: ");
                String message = scanner.nextLine();
                
                String encrypted = encryption.encrypt(message);
                System.out.println("\n---------- RESULT ----------");
                System.out.println("Original Message: " + message);
                System.out.println("Encrypted: " + encrypted);
                
                String decrypted = encryption.decrypt(encrypted);
                System.out.println("Decrypted: " + decrypted);
                System.out.println("-----------------------------");
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
        
        scanner.close();
    }
}

// Factory class to create Encryption objects
public class EncryptionFactory {
    
    // Factory method to create encryption based on type
    public Encryption createEncryption(String encryptionType) {
        if (encryptionType == null || encryptionType.isEmpty()) {
            return null;
        }
        
        switch (encryptionType.toUpperCase()) {
            case "AES":
                return new AESEncryption();
            case "DES":
                return new DESEncryption();
            case "BASE64":
                return new Base64Encryption();
            default:
                System.out.println("Unknown encryption type: " + encryptionType);
                return null;
        }
    }
}

import java.util.Base64;

// Concrete class for Base64 Encryption
public class Base64Encryption implements Encryption {
    
    public Base64Encryption() {
        // No key needed for Base64
    }
    
    @Override
    public String encrypt(String message) {
        try {
            return Base64.getEncoder().encodeToString(message.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public String decrypt(String encryptedMessage) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedMessage);
            return new String(decodedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public String getEncryptionType() {
        return "BASE64";
    }
}

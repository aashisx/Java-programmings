// Encryption Interface
public interface Encryption {
    String encrypt(String message);
    String decrypt(String encryptedMessage);
    String getEncryptionType();
}

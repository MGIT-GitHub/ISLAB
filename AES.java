//AES
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class AES {
    public static void main(String[] args) throws Exception {
        // Generate an AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // 128-bit AES
        SecretKey secretKey = keyGen.generateKey();

        // Initialize the cipher for encryption
        Cipher encryptCipher = Cipher.getInstance("AES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypt a string
        System.out.print("Enter plain text: ");
        Scanner sc = new Scanner(System.in);
        String plaintext = sc.nextLine();
        byte[] encryptedBytes = encryptCipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        String encryptedString = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted: " + encryptedString);

        // Initialize the cipher for decryption
        Cipher decryptCipher = Cipher.getInstance("AES");
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Decrypt the encrypted string
        byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encryptedString));
        String decryptedString = new String(decryptedBytes, StandardCharsets.UTF_8);
        System.out.println("Decrypted: " + decryptedString);
    }
}

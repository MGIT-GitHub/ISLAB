import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Program_10_RC4 {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the text to be encrypted: ");
        Scanner sc = new Scanner(System.in);
        String plaintext = sc.nextLine();
        System.out.println("Enter the key (greater than 4 characters): ");
        String keyString = sc.nextLine();
        sc.close();
        byte[] keyBytes = keyString.getBytes();
        Cipher rc4 = Cipher.getInstance("RC4");
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "RC4");
        rc4.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = rc4.doFinal(plaintext.getBytes());
        String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted: " + encryptedBase64);
        rc4.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decryptedBytes = rc4.doFinal(Base64.getDecoder().decode(encryptedBase64));
        String decryptedText = new String(decryptedBytes);
        System.out.println("Decrypted: " + decryptedText);
    }
}

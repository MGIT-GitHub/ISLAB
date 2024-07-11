import java.util.*;

public class DH {
    // Function to compute (a^b) % p
    public static int power(int a, int b, int p) {
        int result = 1;
        a = a % p;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % p;
            }
            b = b >> 1;
            a = (a * a) % p;
        }
        return result;
    }

    // Function to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Function to check if a number is a primitive root
    public static boolean isPrimitiveRoot(int g, int p) {
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 1; i < p; i++) {
            int res = power(g, i, p);
            if (results.contains(res)) {
                return false;
            }
            results.add(res);
        }
        return true;
    }

    // Function to find all primitive roots of a prime number
    public static ArrayList<Integer> findPrimitiveRoots(int p) {
        ArrayList<Integer> primitiveRoots = new ArrayList<>();
        for (int i = 2; i < p; i++) {
            if (isPrimitiveRoot(i, p)) {
                primitiveRoots.add(i);
            }
        }
        return primitiveRoots;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Case 1: Check if the input number is prime
        System.out.print("Enter a prime number (q): ");
        int p = scanner.nextInt();
        if (!isPrime(p)) {
            System.out.println(p + " is not a prime number.");
            return;
        }

        // Case 2: List eligible primitive roots for the given input
        ArrayList<Integer> primitiveRoots = findPrimitiveRoots(p);
        System.out.println("Primitive roots of " + p + ": " + primitiveRoots);
        if (primitiveRoots.isEmpty()) {
            System.out.println("No primitive roots found for " + p);
            return;
        }
        
        // Choose a primitive root
        System.out.print("Select a primitive root from the list: ");
        int g = scanner.nextInt();
        if (!primitiveRoots.contains(g)) {
            System.out.println(g + " is not a valid primitive root.");
            return;
        }

        // Perform Diffie-Hellman Key Exchange
        System.out.print("Enter private key for A: ");
        int a = scanner.nextInt();
        System.out.print("Enter private key for B: ");
        int b = scanner.nextInt();
        
        int x = power(g, a, p);
        int y = power(g, b, p);
        int ka = power(y, a, p);
        int kb = power(x, b, p);
        
        System.out.println("Public key for A is: " + x);
        System.out.println("Public key for B is: " + y);
        System.out.println("Secret key for A is: " + ka);
        System.out.println("Secret key for B is: " + kb);
        
        // Case 3: Perform encryption and decryption using calculated symmetric key
        System.out.print("Enter the plain text (integer) to encrypt: ");
        int plaintext = scanner.nextInt();
        
        // Encrypt
        int encryptedText = plaintext + ka;
        System.out.println("Encrypted text: " + encryptedText);
        
        // Decrypt
        int decryptedText = encryptedText - kb;
        System.out.println("Decrypted text: " + decryptedText);
        
        scanner.close();
    }
}

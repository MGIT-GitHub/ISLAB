import java.util.*;

public class RC4 {
    static final int n = 8; // number of bits per byte
    static final String key = "101001000001";
    static List<Integer> s = new ArrayList<>();
    static List<Integer> keylist;
    static List<Integer> plaintextBits;
    static List<Integer> keystream = new ArrayList<>();
    static List<Integer> ciphertext = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter plaintext:");
        String plaintext = sc.nextLine();

        System.out.println("Encryption process:");
        encryption(plaintext);
        System.out.println("Decryption process:");
        decryption();
    }

    public static void encryption(String plaintext) {
        initialize();
        keylist = convertToDecimal(key);
        plaintextBits = convertToDecimal(plaintext);
        extendKey();
        keySchedulingAlgorithm();
        pseudoRandomGenerationAlgorithm(plaintextBits.size());
        XOROperation(plaintextBits, ciphertext);
        printBits(ciphertext, "Cipher text");
    }

    public static void decryption() {
        initialize();
        keylist = convertToDecimal(key);
        extendKey();
        keySchedulingAlgorithm();
        pseudoRandomGenerationAlgorithm(ciphertext.size());
        List<Integer> decryptedText = new ArrayList<>();
        XOROperation(ciphertext, decryptedText);
        printBits(decryptedText, "Decrypted text");
    }

    public static void initialize() {
        s.clear();
        for (int i = 0; i < (1 << n); i++) {
            s.add(i);
        }
    }

    public static void keySchedulingAlgorithm() {
        int j = 0;
        for (int i = 0; i < s.size(); i++) {
            j = (j + s.get(i) + keylist.get(i % keylist.size())) % s.size();
            Collections.swap(s, i, j);
        }
    }

    public static void pseudoRandomGenerationAlgorithm(int size) {
        int i = 0, j = 0;
        keystream.clear();
        for (int k = 0; k < size; k++) {
            i = (i + 1) % s.size();
            j = (j + s.get(i)) % s.size();
            Collections.swap(s, i, j);
            int t = (s.get(i) + s.get(j)) % s.size();
            keystream.add(s.get(t));
        }
    }

    public static void XOROperation(List<Integer> input, List<Integer> output) {
        for (int i = 0; i < input.size(); i++) {
            output.add(input.get(i) ^ keystream.get(i));
        }
    }

    public static void extendKey() {
        int diff = s.size() - keylist.size();
        for (int i = 0; i < diff; i++) {
            keylist.add(keylist.get(i % keylist.size()));
        }
    }

    public static List<Integer> convertToDecimal(String input) {
        List<Integer> decimalList = new ArrayList<>();
        for (int i = 0; i < input.length(); i += n) {
            decimalList.add(Integer.parseInt(input.substring(i, Math.min(i + n, input.length())), 2));
        }
        return decimalList;
    }

    public static void printBits(List<Integer> data, String label) {
        StringBuilder bits = new StringBuilder();
        for (int i : data) {
            bits.append(String.format("%0" + n + "d", Integer.parseInt(Integer.toBinaryString(i))));
        }
        System.out.println(label + ": " + bits);
    }
}

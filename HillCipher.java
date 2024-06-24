import java.util.Scanner;

class HillCipher {
    // Function to get the key matrix from the key string
    static void getKeyMatrix(String key, int keyMatrix[][]) {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keyMatrix[i][j] = (key.charAt(k)) % 65;
                k++;
            }
        }
    }

    // Function to perform matrix multiplication and find the cipher matrix
    static void encrypt(int cipherMatrix[][], int keyMatrix[][], int messageVector[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                cipherMatrix[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    cipherMatrix[i][j] += keyMatrix[i][k] * messageVector[k][j];
                }
                cipherMatrix[i][j] = cipherMatrix[i][j] % 26;
            }
        }
    }

    // Function to encrypt the message
    static void HC(String message, String key) {
        int[][] keyMatrix = new int[3][3];
        getKeyMatrix(key, keyMatrix);

        int[][] messageVector = new int[3][1];
        for (int i = 0; i < 3; i++) {
            messageVector[i][0] = (message.charAt(i)) % 65;
        }

        int[][] cipherMatrix = new int[3][1];
        encrypt(cipherMatrix, keyMatrix, messageVector);

        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            ciphertext.append((char) (cipherMatrix[i][0] + 65));
        }

        System.out.println("Cipher text: " + ciphertext);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the plain text (3 letters): ");
        String message = sc.nextLine().toUpperCase();
        System.out.println("Enter the key (9 letters): ");
        String key = sc.nextLine().toUpperCase();

        HC(message, key);
    }
}

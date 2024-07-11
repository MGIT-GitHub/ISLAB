import java.util.Scanner;

class RailFence {
    public static String encryptRailFence(String text, int key) {
        char[][] rail = new char[key][text.length()];

        // Fill the rail matrix with empty characters
        for (int i = 0; i < key; i++)
            for (int j = 0; j < text.length(); j++)
                rail[i][j] = '\n'; // use '\n' as a marker for empty spots

        boolean dirDown = false;
        int row = 0, col = 0;

        for (int i = 0; i < text.length(); i++) {
            // Check the direction of the flow
            if (row == 0 || row == key - 1) {
                dirDown = !dirDown;
            }

            // Fill the current character in the rail matrix
            rail[row][col++] = text.charAt(i);

            // Move to the next row
            if (dirDown) {
                row++;
            } else {
                row--;
            }
        }

        // Construct the encrypted text from the rail matrix
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < text.length(); j++) {
                if (rail[i][j] != '\n') {
                    result.append(rail[i][j]);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text to encrypt:");
        String text = sc.nextLine();
        int key = 5;
        System.out.println("Encrypted text of '" + text + "' with key = " + key + " is : ");
        System.out.println(encryptRailFence(text, key));
        sc.close();
    }
}

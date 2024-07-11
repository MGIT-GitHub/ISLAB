import java.util.*;

public class AdditiveCeaser {
    public static void main(String[] args) {
        String pt = "", ct = "";
        String c = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Enter plain text:");
        Scanner sc = new Scanner(System.in);
        String p = sc.nextLine();
        p = p.toLowerCase();
        System.out.println("Enter your choice (1 for additive, 2 for ceaser):");
        int n = sc.nextInt();

        switch (n) {
            case 1:
                System.out.println("Enter key:");
                int m = sc.nextInt();
                System.out.println("Cipher text:");
                for (int i = 0; i < p.length(); i++) {
                    int t = c.indexOf(p.charAt(i));
                    ct += c.charAt((t + m) % 26);
                }
                System.out.println(ct);
                System.out.println("Plain text:");
                for (int i = 0; i < ct.length(); i++) {
                    int t = c.indexOf(ct.charAt(i));
                    t = t - m;
                    if (t < 0) {
                        t = t + 26;
                    }
                    pt += c.charAt(t);
                }
                System.out.println(pt);
                break;
            case 2:
                System.out.println("Cipher text:");
                for (int i = 0; i < p.length(); i++) {
                    int t = c.indexOf(p.charAt(i));
                    ct += c.charAt((t + 3) % 26);
                }
                System.out.println(ct);
                System.out.println("Plain text:");
                for (int i = 0; i < ct.length(); i++) {
                    int t = c.indexOf(ct.charAt(i));
                    t = t - 3;
                    if (t < 0) {
                        t = t + 26;
                    }
                    pt += c.charAt(t);
                }
                System.out.println(pt);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
        sc.close();
    }
}

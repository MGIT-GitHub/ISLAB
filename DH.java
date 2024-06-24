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
        System.out.print("Enter a prime number: ");
        int p = scanner.nextInt();
        ArrayList<Integer> primitiveRoots = findPrimitiveRoots(p);
        System.out.println("Select primitiveRoots of "+p +"from below\n" + primitiveRoots);
        //Defiee hellmen key exchangeint g=scanner.nextInt();
        System.out.println("Give private key
        
        of A & B: ");
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int x=power(g,a,p);
        int y=power(g,b,p);
        int ka=power(y,a,p);
        int kb=power(x,b,p);
        System.out.println("Public key for A is : "+x);
        System.out.println("Public key for B is : "+y);
        System.out.println("Secret key for A is : "+ka);
        System.out.println("Secret key for B is : "+kb);
        scanner.close();
    }
}

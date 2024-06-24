//RSA
import java.util.*;
public class RSA
{
    public static boolean isPrime(int a) {
        if (a <= 1) return false; // 0, 1, and negative numbers are not prime
        if (a == 2) return true;  // 2 is the only even prime number
        if (a % 2 == 0) return false; // Other even numbers are not primes
    
        for (int i = 3; i <= Math.sqrt(a); i += 2) {
            if (a % i == 0) return false;
        }
        return true;
    }
    public static void tot(int t){
        for(int i=0;i<t;i++){
            if(gcd(i,t)==1)
                System.out.print(i+" ");
        }
    }
    public static int gcd(int x,int y){
        if(y==0)
            return x;
        else
            return gcd(y,x%y);
    }
    public static int mi(int r1,int r2){
        int t1=mi_gcd(r1,r2,1,0,0,1);
        if(t1<0)
            return t1+r1;
        return t1%r1;
    }
    public static int mi_gcd(int r1,int r2,int s1,int s2,int t1,int t2){
        if(r1==1 && r2==0)
            return t1;
        int q=r1/r2;
        int r=r1-q*r2;
        int s=s1-q*s2;
        int t=t1-q*t2;
        return mi_gcd(r2,r,s2,s,t2,t);
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Enter two prime numbers: ");
	    int a=sc.nextInt();
	    int b=sc.nextInt();
	    if(!isPrime(a))
	    {
	        System.out.println("A is not prime");
	        return;
	    }
	    if(!isPrime(b))
	    {
	    System.out.println("B is not prime");
	        return;
	        
	    }
	    int n=a*b;
	    int t=(a-1)*(b-1);
	    tot(t);
	    System.out.println("Choose e value from above: ");
	    int e=sc.nextInt();
	    int d=mi(t,e);
	    System.out.println("Public key "+e+","+t);
	    System.out.println("Private key "+d+","+t);
	    System.out.print("Enter Plain text: ");
	    int pt=sc.nextInt();
	    double ct= Math.pow(pt,e)%n;
	    System.out.println("Cipher text is: "+ct);
	    double pt1=Math.pow(ct,d)%n;
	    System.out.println("Plain text is :"+pt1);
	       
	}
}

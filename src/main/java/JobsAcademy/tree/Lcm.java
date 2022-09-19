package JobsAcademy.tree;
import java.util.Scanner;

public class Lcm {
	public static long gcd(long a, long b) {
		while(b > 0) {
	        long temp = b;
	        b = a % b;
	        a = temp;
	    }
	    return a;
	}
	public static long lcm(long a, long b) {
		return (a*b)/gcd(a,b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextInt();
		long b = sc.nextInt();
		
		System.out.println(lcm(a, b));
	}
}

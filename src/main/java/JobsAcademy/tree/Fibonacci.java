package JobsAcademy.tree;
import java.util.Scanner;

public class Fibonacci {
	public static int fibo(int a1, int a2) {
		return a1+a2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int a0=0;
		int a1=1;
		int a2=0;
		if(n==0) {
			System.out.println(a0);
		}
		else if(n==1) {
			System.out.println(a1);
		}
		else {
			for(int i=0;i<n-1;i++) {
				a2=fibo(a0,a1);
				a0=a1;
				a1=a2;
			}
			System.out.println(a2);
		}
	}

}

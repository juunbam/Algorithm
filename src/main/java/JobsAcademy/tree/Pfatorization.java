package JobsAcademy.tree;
import java.util.Scanner;

public class Pfatorization {


	public static void pfactorization(int n) {
		
		for(int i=2;i<n;i++) {
			if(n%i==0) {
				n=n/i;
				System.out.println(i);
				i=2;
			}
		}
		System.out.println(n);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		pfactorization(n);
	}

}

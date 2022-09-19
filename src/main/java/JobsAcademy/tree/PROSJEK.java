package JobsAcademy.tree;
import java.util.Scanner;

public class PROSJEK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		long[] a = new long[n];
		
		for(int i=0;i<n;i++) {
			a[i] = sc.nextLong();
		}
		long tot=0;
		for(int i=0;i<n;i++) {
			a[i]*=(i+1);
		}
		for(int i=(n-1);i>0;i--) {
			a[i]-=a[i-1];
		}
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
	}

}

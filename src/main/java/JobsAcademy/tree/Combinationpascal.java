package JobsAcademy.tree;
import java.util.Scanner;

public class Combinationpascal {
	public static long factorial(int n) {
		int total = 1;
		if(n==0)
			return total;
		for(int i=1;i<=n;i++)
			total*=i;
		return total;
	}
	public static long combination(int n, int m) {
		long c = 1;
		int tmp = n;
		if(m==0 || n==m)
			return 1;
		
		int k=1;
		for(int i=0;i<(n-m);i++) {
			c *= tmp--;
			if(k<=(n-m) && c%k==0) {
				c /= k;
				k++;
			}	
		}
		
		for(int i=k;i<=(n-m);i++) {
			c /= i;
		}
		
		return c;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		if(m<(n/2))
			m=n-m;
		System.out.println(combination(n,m));
	}

}

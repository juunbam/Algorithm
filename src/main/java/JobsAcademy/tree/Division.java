package JobsAcademy.tree;
import java.util.Scanner;

public class Division {
	public int cnt=0;
	public void division(String a, int n, int m) {
		if(n==1 || m<=1) {
			if(m>0) {
				division(a+"1+", 1, m-1);
			}
			else {
				System.out.println(a.substring(0, a.length()-1));
				cnt++;
			}
		}
		else {
			for(int i=n;i>0;i--) {
				if(i<=m)
					division(a+i+"+", i, m-i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Division d = new Division();
		d.division("", N-1, N);
		System.out.println(d.cnt);
	}
}

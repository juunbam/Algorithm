package JobsAcademy.tree;
import java.util.Scanner;

public class Mountain {
	public static String mountain(int N) {
		String a="";
		if(N>=1) {
			return mountain(N-1)+N+mountain(N-1);
		}
		else
			return a;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		System.out.println(Mountain.mountain(N));
		
	}
}

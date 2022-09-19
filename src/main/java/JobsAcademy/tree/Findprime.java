package JobsAcademy.tree;
import java.util.Scanner;

public class Findprime {
	public static boolean findprime(int n) {
		boolean flag=true;
		
		int m=(int) Math.sqrt(n);
		if(n == 1)
			flag = false;
		else{
			for(int i=2;i<=m;i++) {
				if(n%i == 0)
					flag = false;
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		int cnt=0;
		for(int i=0;i<n;i++) {
			if(findprime(a[i]))
				cnt++;
		}
		System.out.println(cnt);
	}

}

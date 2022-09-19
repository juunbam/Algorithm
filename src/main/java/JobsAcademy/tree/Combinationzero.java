package JobsAcademy.tree;
import java.util.Scanner;

public class Combinationzero {
	public static int findTwo(int n) {
		int cnt=0;
		while(n%2==0) {
			n=n/2;
			cnt++;
		}
		return cnt;
	}
	public static int findFive(int n) {
		int cnt=0;
		while(n%5==0) {
			n=n/5;
			cnt++;
		}
		return cnt;
	}
	public static long combinationZero(int n, int m) {
		int min;
		int tmp = n;
		if(m==0 || n==m)
			return 0;
		
		int two=0;
		int five=0;
		
		for(int i=0;i<(n-m);i++) {
			two += findTwo(tmp);
			five += findFive(tmp);
			tmp--;
		}
		
		for(int i=1;i<=(n-m);i++) {
			two -= findTwo(i);
			five -= findFive(i);
		}
		min=Math.min(two, five);
		if(min<=0)
			return 0;
		else 
			return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		System.out.println(combinationZero(n,m));
	}

}

package JobsAcademy.tree;
import java.util.Arrays;
import java.util.Scanner;

public class Streetree {
	public static int gcd(int a, int b) {
		while(b > 0) {
	        int temp = b;
	        b = a % b;
	        a = temp;
	    }
	    return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] t = new int[n];
		
		for(int i=0;i<n;i++) {
			t[i] = sc.nextInt();
		}
		
		int min = 0;
		for(int i=0;i<n-2;i++) {
			int a = t[i+2]-t[i+1];
			int b = t[i+1]-t[i];
			int tmp = gcd(a,b);
			if(i==0) {
				min=tmp;
			}
			else {
				if(min>tmp)
					min=tmp;
			}
		}
		
		int start = t[0];
		int cnt=0;
		for(int i=1;i<n;i++) {
			start = start + min;
			if(start != t[i]) {
				cnt++;
				i--;
			}
		}
		System.out.println(cnt);
		
	}

}

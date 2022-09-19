package JobsAcademy.tree;
import java.util.Scanner;

public class Fmttalpha {
	public static void cntOperation(int d, int i) {
		while(d>=0) {
			i++;
			d=d-(i*2);
		}
		d=d+(i*2);
		i=i-1;
		if(d==0) {
			System.out.println(i*2);
			return;
		}
		
		if(d > i+1) {
			System.out.println(i*2+2);
		}
		else if(d <= i+1) {
			System.out.println(i*2+1);
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int dist = y-x;
		
		cntOperation(dist, 0);
	}

}

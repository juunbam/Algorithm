package JobsAcademy.tree;
import java.util.Scanner;

public class Nextnum {
	public static void nextnum(int[] a) {
		if(a[2]-a[1] == a[1]-a[0]) {
			System.out.println("AP "+(a[2]+(a[1]-a[0])));
		}
		else {
			System.out.println("GP "+(a[2]*(a[1]/a[0])));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int[] a = new int[3];
			for(int i=0;i<3;i++) {
				a[i] = sc.nextInt();
			}
			if(a[0] == 0 && a[1] == 0 && a[2] == 0)
				break;
			else {
				nextnum(a);
			}
		}
	}

}

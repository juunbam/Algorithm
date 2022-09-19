package JobsAcademy.tree;
import java.util.Scanner;

public class Sequencesum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int[][] a = new int[n][n];
		int[] b = new int[n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j] = sc.nextInt();
		
		b[2] = (a[0][2]-a[0][1]+a[1][2])/2;
		
		for(int i=0;i<n;i++) {
			if(i!=2)
				b[i] = a[2][i]-b[2];
		}
		for(int i=0;i<n;i++)
			System.out.print(b[i]+" ");
	}

}

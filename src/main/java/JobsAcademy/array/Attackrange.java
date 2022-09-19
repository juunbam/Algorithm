package JobsAcademy.array;
import java.util.Scanner;

public class Attackrange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		
		int y = sc.nextInt();
		int x = sc.nextInt();
		int r = sc.nextInt();
		
		int[][] range = new int[r*2+1][r*2+1];
		int M=r;
		for(int i=0;i<r;i++) {
			for(int j=0;j<M+1;j++) {
				range[(j+i)][(r-j)]=r-i;
				range[(j+i)][(r*2)-(r-j)]=r-i;
				range[(r*2)-(j+i)][(r-j)]=r-i;
				range[(r*2)-(j+i)][(r*2)-(r-j)]=r-i;
			}
			M--;
		}
		x=x-r-1;
		y=y-r-1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if((i-y) >= 0  && (j-x) >= 0 && (i-y) < (r*2+1) && (j-x) < (r*2+1)) {
					if(i-y == r && j-x == r)
						System.out.print("x ");
					else
						System.out.print(range[i-y][j-x]+" ");
				}
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
		
//		for(int i=0;i<(r*2+1);i++) {
//			for(int j=0;j<(r*2+1);j++) {
//				System.out.print(range[i][j]+" ");
//			}
//			System.out.println();
//		}
		
	}

}

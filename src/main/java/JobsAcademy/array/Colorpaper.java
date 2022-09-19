package JobsAcademy.array;
import java.util.Scanner;

public class Colorpaper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] a = new int[101][101];
		
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				a[i][j]=0;
			}
		}
		
		for(int i=1;i<=N;i++) {
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			int w=sc.nextInt();
			int h=sc.nextInt();
			for(int j=x1;j<(x1+w);j++) {
				for(int k=y1;k<(y1+h);k++) {
					a[j][k] = i;
				}
			}
			
		}
		
		
		for(int i=1;i<=N;i++) {
			int cnt=0;
			for(int j=0;j<101;j++) {
				for(int k=0;k<101;k++) {
					if(a[j][k]==i) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		
	}

}

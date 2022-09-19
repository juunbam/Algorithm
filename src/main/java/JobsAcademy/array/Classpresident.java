package JobsAcademy.array;
import java.util.Scanner;

public class Classpresident {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int Answer=0;
		int N = sc.nextInt();
		
		int[][] a = new int[N][5];
		int[][] b = new int[N][N];
		for(int i=0;i<N;i++) 
			for(int j=0;j<5;j++) 
				a[i][j] = sc.nextInt();
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				b[i][j]=0;
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(j!=k) {
						if(a[j][i] == a[k][i]) {
							b[j][k]=1;
						}
					}
				}
			}
		}
		
		int max=0;
		for(int i=0;i<N;i++) {
			int tmp=0;
			for(int j=0;j<N;j++) {
				if(b[i][j]==1) {
					tmp++;
				}
			}
			if(tmp>max) {
				max=tmp;
				Answer = i+1;
			}
		}
		if(Answer == 0)
			Answer = 1;
		
		System.out.println(Answer);
	}

}

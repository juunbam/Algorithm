package JobsAcademy.array;

import java.io.FileInputStream;
import java.util.Scanner;


public class Bingo {
	static int Answer;

	public static int bingo(int[][] a, int N) {
		int b=0;
		int cnt=0;
		for(int i=0;i<N;i++) {//ъ░?ыб? 
			cnt=0;
			for(int j=0;j<N;j++) {
				if(a[i][j]==0)
					cnt++;
			}
			if(cnt==N)
				b++;
		}
		
		for(int i=0;i<N;i++) {//?Д╕ыб? 
			cnt=0;
			for(int j=0;j<N;j++) {
				if(a[j][i]==0)
					cnt++;
			}
			if(cnt==N)
				b++;
		}
		
		cnt=0;
		for(int i=0;i<N;i++) {
			if(a[i][i]==0)
				cnt++;
		}
		if(cnt==N)
			b++;
		
		cnt=0;
		for(int i=0;i<N;i++) {
			if(a[i][N-i-1]==0)
				cnt++;
		}
		if(cnt==N)
			b++;
		
		return b;
	}
	public static void main(String args[]) throws Exception	{

		Scanner sc = new Scanner(System.in);
		int bingo=0;
		int N = 5;
		int[][] a = new int[5][5];
		int index=0;
		for(int i=0;i<N;i++) 
			for(int j=0;j<N;j++) 
				a[i][j] = sc.nextInt();
	
		for(int i=0;i<25;i++) {
			int num=sc.nextInt();
			int found = 0;
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(a[j][k]==num) {
						a[j][k]=0;
						found=1;
						break;
					}
				}
				if(found==1) 
					break;
			}
			
			bingo = Bingo.bingo(a, N);
			if(bingo == 3) {
				index = i+1;
				break;
			}
			else 
				bingo=0;
		}
		System.out.println(index);
		
	}
}

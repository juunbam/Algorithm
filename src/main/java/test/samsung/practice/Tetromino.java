package test.samsung.practice;
import java.util.Scanner;

public class Tetromino {
	
	public static int[][][] type = {{{0,0},{1,0},{2,0},{2,1}},{{0,0},{1,0},{1,1},{2,1}},{{0,0},{0,1},{0,2},{1,1}},
			{{0,0},{0,1},{1,0},{1,1}},{{0,0},{0,1},{0,2},{0,3}}};
	
	public static void rotate(int n){
		int[][] t= type[n];
		int rx = t[0][0];
		int ry = t[0][1];
		
		for(int i=1;i<t.length;i++) {
			int cx = t[i][0];
			int cy = t[i][1];
			
			int dx = rx - cx;
			int dy = ry - cy;
			
			t[i][0] = rx+dy;
			t[i][1] = ry-dx;
		}
	}
	public static void reverse(int n) {
		int[][] t= type[n];
		int rx = t[0][0];
		int ry = t[0][1];
		
		for(int i=1;i<t.length;i++) {
			int cx = t[i][0];
			int cy = t[i][1];
			
			if(ry != cy) {
				t[i][1] = -cy;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int Answer = 0;
		for(int t=0;t<5;t++) {
			for(int l=0;l<8;l++) {
				if(l==4) {
					reverse(t);
				}
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						int total = 0;
						for(int k=0;k<4;k++) {
							int x = i+type[t][k][0];
							int y = j+type[t][k][1];
							
							if(x<0 || x>=N || y<0 || y>=M) {
								total = 0;
								
								break;
							}
							else {
								total += map[x][y];
							}
						}
						if(total>Answer) {
							Answer = total;
						}
					}
					
				}
				if(l==3 && t==2) {
					break;
				}
				if(l==1 && t==4) {
					break;
				}
				if(t==3) {
					break;
				}
				rotate(t);
			}
		}
		System.out.println(Answer);
	}
	

}

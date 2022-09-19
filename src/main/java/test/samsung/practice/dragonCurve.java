package test.samsung.practice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class dragonCurve {
	public static int Answer;
	public static final int R=0, U=1, L=2, D=3;
	public static int[][] direction = {{1, 0},{0, -1},{-1, 0},{0, 1}};
	public static int[][] square = {{1, 0},{1, 1},{0, 1}};
	public static int findSquare(boolean[][] v) {
		int cnt = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(v[i][j] && v[i+1][j] && v[i][j+1] && v[i+1][j+1])
					cnt++;
			}
		}
		return cnt;
	}
	public static void setCurve(int g, ArrayList<Loc> d) {
		for(int i=0;i<g;i++) {
			int n = d.size();
			int rx = d.get(n-1).x;
			int ry = d.get(n-1).y;
			
			for(int j=n-2;j>=0;j--) {
				int cx = d.get(j).x;
				int cy = d.get(j).y;
				
				int dx = rx - cx;
				int dy = ry - cy;
				
				d.add(new Loc(rx+dy, ry-dx));
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		boolean[][] visit = new boolean[101][101];
		ArrayList<ArrayList<Loc>> dragon= new ArrayList<ArrayList<Loc>>();
		for(int i=0;i<N;i++) {
			dragon.add(new ArrayList<Loc>());
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			
			dragon.get(i).add(new Loc(x, y));
			dragon.get(i).add(new Loc(x+direction[d][0], y+direction[d][1]));
			if(g>0) {
				setCurve(g, dragon.get(i));
			}
			
			for(int j=0;j<dragon.get(i).size();j++) {
				x = dragon.get(i).get(j).x;
				y = dragon.get(i).get(j).y;
				visit[x][y] = true;
			}
		}
		Answer = 0;
		Answer = findSquare(visit);
		System.out.println(Answer);
		
		
	}

}

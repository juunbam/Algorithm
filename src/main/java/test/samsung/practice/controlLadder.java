package test.samsung.practice;
import java.util.ArrayList;
import java.util.Scanner;

public class controlLadder {
	public static boolean pos;
	public static int Answer;
	public static void controlL(ArrayList<Loc> p, boolean[][] l, int n, int i, int len, int index, boolean[] v) {
		if(index < len && i<n) {
			v[index] = true;
			controlL(p, l, n, i+1, len, index+1, v);
			v[index] = false;
			controlL(p, l, n, i, len, index+1, v);
		}
		if(n==i) {
			boolean flag = true;
			for(int j=0;j<len;j++) {
				if(v[j]) {
					int x = p.get(j).x;
					int y = p.get(j).y;
					if(!l[x][y] && !l[x][y+1] && !l[x][y-1]) {
						l[x][y] = true;
					}
					else {
						flag = false;
						break;
					}
				}
			}
			
			
			if(flag) {
				for(int k=1;k<l[0].length;k++) {
					int t = getResult(l, k);
					if(t!=k) {
						flag=false;
						break;
					}
				}
			}
			
			if(flag) {
				pos = true;
			}
			
			for(int j=0;j<len;j++) {
				if(v[j]) {
					int x = p.get(j).x;
					int y = p.get(j).y;
					l[x][y] = false;
				}
			}
		}
		
		
	}
	public static int getResult(boolean[][] l, int n) {
		int index = 1;
		while(true) {
			boolean flag = false;
			for(int i=index;i<l.length;i++) {
				if(l[i][n]) {
					n=n+1;
					index = i+1;
					flag = true;
					break;
				}
				if(l[i][n-1]) {
					n=n-1;
					index = i+1;
					flag = true;
					break;
				}
			}
			if(!flag) 
				return n;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int H = sc.nextInt();
		
		boolean[][] line = new boolean[H+1][N+1];
		
		for(int i=0;i<M;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			line[x][y] = true;
		}
		ArrayList<Loc> p_line = new ArrayList<Loc>();
		for(int i=1;i<=H;i++) {
			for(int j=1;j<N;j++) {
				if(!line[i][j] && !line[i][j+1]) {
					p_line.add(new Loc(i, j));
				}
			}
		}
		Answer = -1;
		boolean[] visit = new boolean[p_line.size()];
		for(int i=0;i<=3;i++) {
			controlL(p_line, line, i, 0, p_line.size(), 0, visit);
			if(pos) {
				Answer = i;
				break;
			}
		}
		System.out.println(Answer);
		
		
	}

}

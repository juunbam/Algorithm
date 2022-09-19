package JobsAcademy.tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Danji {
	public static int[][] arr;
	public static boolean[][] visit;
	public static int N;
	public static int bfs(int x, int y) {
		ArrayList<Integer> qx = new ArrayList<Integer>();
		ArrayList<Integer> qy = new ArrayList<Integer>();
		
		int cnt = 0;
		
		visit[x][y] = true;
		qx.add(x);
		qy.add(y);
		
		while(!qx.isEmpty() && !qy.isEmpty()) {
			int tx = qx.remove(0);
			int ty = qy.remove(0);
			cnt++;
			if(tx+1 < N && visit[tx+1][ty] == false && arr[tx+1][ty] == 1) {
				qx.add(tx+1);
				qy.add(ty);
				visit[tx+1][ty] = true;
			}
			if(ty+1 < N && visit[tx][ty+1] == false && arr[tx][ty+1] == 1) {
				qx.add(tx);
				qy.add(ty+1);
				visit[tx][ty+1] = true;
			}
			if(tx-1 >= 0 && visit[tx-1][ty] == false && arr[tx-1][ty] == 1) {
				qx.add(tx-1);
				qy.add(ty);
				visit[tx-1][ty] = true;
			}
			if(ty-1 >= 0 && visit[tx][ty-1] == false && arr[tx][ty-1] == 1) {
				qx.add(tx);
				qy.add(ty-1);
				visit[tx][ty-1] = true;
			}
		}
		
		return cnt;
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(sc.nextLine());
		ArrayList<Integer> c = new ArrayList<Integer>();
		arr = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String input="";
			if(sc.hasNextLine())
				input = sc.nextLine();
			if(input.compareTo("")!=0) {
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(input.substring(j, j+1));
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int cnt = 0;
				if(visit[i][j] == false && arr[i][j] == 1) {
					cnt = bfs(i,j);
					c.add(cnt);
				}
			}
		}
		Collections.sort(c);
		System.out.println(c.size());
		for(int i=0;i<c.size();i++) {
			System.out.println(c.get(i));
		}
	}

}

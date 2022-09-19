package JobsAcademy.tree;
import java.util.ArrayList;
import java.util.Scanner;

public class Findroute {
	
	public static int N;
	public static int M;
	public static int[][] Maze;
	public static int[][] depth; 
	
	public static void bfs(int sx, int sy, int dx, int dy, int cnt, boolean[][] v) {
		ArrayList<Integer> qx = new ArrayList<Integer>();
		ArrayList<Integer> qy = new ArrayList<Integer>();
		v[sx][sy] = true;
		qx.add(sx);
		qy.add(sy);
		depth[sx][sy] = 1;
		while(!qx.isEmpty() && !qy.isEmpty()) {
			int tx = qx.remove(0);
			int ty = qy.remove(0);
			if(tx == dx && ty == dy) {
				break;
			}
			if(tx+1 < N && v[tx+1][ty] == false && Maze[tx+1][ty] == 0) {
				qx.add(tx+1);
				qy.add(ty);
				depth[tx+1][ty] = depth[tx][ty]+1;
				v[tx+1][ty] = true;
			}
			if(tx-1 >= 0 && v[tx-1][ty] == false && Maze[tx-1][ty] == 0) {
				qx.add(tx-1);
				qy.add(ty);
				depth[tx-1][ty] = depth[tx][ty]+1;
				v[tx-1][ty] = true;
			}
			if(ty+1 < M && v[tx][ty+1] == false && Maze[tx][ty+1] == 0){
				qx.add(tx);
				qy.add(ty+1);
				depth[tx][ty+1] = depth[tx][ty]+1;
				v[tx][ty+1] = true;
			}
			if(ty-1 >= 0 && v[tx][ty-1] == false && Maze[tx][ty-1] == 0) {
				qx.add(tx);
				qy.add(ty-1);
				depth[tx][ty-1] = depth[tx][ty]+1;
				v[tx][ty-1] = true;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		Maze = new int[N][M];
		depth = new int[N][M];
		
		boolean[][] visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int input=0;
				if(sc.hasNextInt())
					input = sc.nextInt();
				Maze[i][j] = input;
			}
		}
		
		bfs(N-1,0,0,M-1,0,visit);
		System.out.println(depth[0][M-1]-1);
	}

}

package JobsAcademy.tree;
import java.util.ArrayList;
import java.util.Scanner;

public class Wormvirus {
	public static int Nv;
	public static int Ne;
	public static int[][] connections;
	public static boolean[] visit;
	public static int cnt;
	
	public static void bfs(int r) {
		ArrayList<Integer> q = new ArrayList<Integer>();
		q.add(r);
		visit[r] = true;
		while(!q.isEmpty()) {
			int node = q.remove(0);
			cnt++;
			for(int i=1;i<Nv;i++) {
				if(!visit[i] && connections[node][i] == 1) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Nv = sc.nextInt()+1;
		Ne = sc.nextInt();
		visit = new boolean[Nv];
		connections = new int[Nv][Nv];
		for(int i=0;i<Ne;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			connections[a][b] = 1;
			connections[b][a] = 1;
		}
		cnt=0;
		bfs(1);
		System.out.println(cnt-1);
	}

}

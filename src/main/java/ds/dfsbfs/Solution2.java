package ds.dfsbfs;
import java.util.ArrayList;

public class Solution2 {
	public static boolean[] visit;
	public static void bfs(int[][] c, int r) {
		ArrayList<Integer> q = new ArrayList<Integer>();
		
		q.add(r);
		visit[r] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.remove(0);
			
			for(int i=0;i<c.length;i++) {
				if(!visit[i] && c[tmp][i] == 1) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		visit = new boolean[n];
		int cnt=0;
		for(int i=0;i<n;i++) {
			if(!visit[i]) {
				cnt++;
				bfs(computers, i);
			}
		}
		System.out.println(cnt);
		
	}

}

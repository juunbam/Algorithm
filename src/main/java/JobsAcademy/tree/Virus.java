package JobsAcademy.tree;
import java.util.ArrayList;
import java.util.Scanner;

public class Virus {
	public static int N;
	public static boolean[] visit;
	public static int bfs(int r) {
		int cnt = 0;
		ArrayList<Integer> q = new ArrayList<Integer>();
		q.add(r);
		visit[r] = true;
		
		while(!q.isEmpty()) {
			int t = q.remove(0);
			cnt++;
			if(t*2 <= N) {
				if(visit[t*2] == false) {
					q.add(t*2);
					visit[t*2] = true;
				}
			}
			if(t/3 > 0) {
				if(visit[t/3] == false) {
					q.add(t/3);
					visit[t/3] = true;
				}
				
			}
		}
		
		return N-cnt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		visit = new boolean[N+1];
		int r = sc.nextInt();
		
		System.out.println(bfs(r));
	}

}

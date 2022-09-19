package JobsAcademy.tree;
import java.util.ArrayList;
import java.util.Scanner;

public class Weirdcal {
	public static int N;
	public static final int MUL = 2;
	public static final int DIV = 3;
	public static final int MAX = 100000;
	public static boolean[] visit = new boolean[MAX];
	public static int[] depth = new int[MAX];
	public static void bfs() {
		ArrayList<Integer> q = new ArrayList<Integer>();
		q.add(1);
		
		while(!q.isEmpty()) {
			int tmp = q.remove(0);
			if(tmp == N) {
				break;
			}
			if(tmp * MUL < MAX) {
				if(visit[tmp * MUL] == false) {
					q.add(tmp * MUL);
					visit[tmp * MUL] = true;
					depth[tmp * MUL] = depth[tmp]+1;
				}
			}
			if(tmp > 0) {
				if(visit[tmp / DIV] == false) {
					q.add(tmp / DIV);
					visit[tmp / DIV] = true;
					depth[tmp / DIV] = depth[tmp]+1;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		bfs();
		System.out.println(depth[N]);
	}

}

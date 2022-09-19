package JobsAcademy.tree;
import java.util.ArrayList;
import java.util.Scanner;

public class Dfsbfs {
	public static int Nv;
	public static int Ne;
	public static int[][] nodes;
	public static boolean[] visit;
	public static void bfs(int r) {
		ArrayList<Integer> q = new ArrayList<Integer>();
		String a="";
		visit[r] = true;
		q.add(r);
		
		while(!q.isEmpty()) {
			int tmp = q.remove(0);
			a+=tmp+" ";
			for(int i=0;i<Nv;i++) {
				if(!visit[i] && nodes[tmp][i] == 1) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
		System.out.println(a);
	}
	public static void dfs(int r) {
		ArrayList<Integer> s = new ArrayList<Integer>();
		String a="";
		visit[r] = true;
		s.add(r);
		System.out.print(r+" ");
		while(!s.isEmpty()) {
			for(int i=0;i<Nv;i++) {
				int tmp = s.get(s.size()-1);
				if(!visit[i] && nodes[tmp][i] == 1) {
					visit[i] = true;
					System.out.print(i+" ");
					s.add(i);
					tmp=i;
					i = -1;
				}
			}
			s.remove(s.size()-1);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		Nv = input.nextInt();
		Ne = input.nextInt();
		nodes = new int[Nv][Nv];
		visit = new boolean[Nv];
		
		for(int i=0;i<Ne;i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			
			nodes[a][b] = 1;
			nodes[b][a] = 1;
		}
		dfs(0);
		for(int i=0;i<Nv;i++) {
			visit[i] = false;
		}
		bfs(0);
		
	}

}

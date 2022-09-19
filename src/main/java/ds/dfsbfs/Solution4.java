package ds.dfsbfs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Route {
	ArrayList<Integer> r;
	int l;
	
	public Route(ArrayList<Integer> r, int l) {
		super();
		this.r = r;
		this.l = l;
	}
	
}
public class Solution4 {
	public static ArrayList<String> cities;
	public static HashMap<String, Integer> map;
	public static void bfs(int[][] t, int r) {
		ArrayList<Route> q= new ArrayList<Route>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(r);
		q.add(new Route(a, r));
		while(!q.isEmpty()) {
			Route tmp = q.remove(0);
			ArrayList<Integer> rt = tmp.r;
			int lt = tmp.l;
			
			for(int j=0;j<t[lt].length;j++) {
				
			}
		}
	}
	public static int[][] Edges(String[][] tickets){
		cities = new ArrayList<String>();
		map= new HashMap<String, Integer>();
		for(int i=0;i<tickets.length;i++) {
			for(int j=0;j<2;j++) {
				if(!cities.contains(tickets[i][j])) {
					cities.add(tickets[i][j]);
				}
			}
		}
		Collections.sort(cities);
		for(int i=0;i<cities.size();i++) {
			map.put(cities.get(i), i);
		}
		int[][] t = new int[cities.size()][cities.size()];
		int n = tickets.length;
		for(int i=0;i<n;i++) {
			String s = tickets[i][0];
			String d = tickets[i][1];
			int x = map.get(s);
			int y = map.get(d);
			
			t[x][y] = 1;
		}
		return t;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		int[][] Ge = Edges(tickets);
		for(int i=0;i<Ge.length;i++) {
			for(int j=0;j<Ge.length;j++) {
				System.out.print(Ge[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}

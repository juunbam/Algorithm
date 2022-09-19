package ds.dfsbfs;
import java.util.ArrayList;
import java.util.Collections;

public class Solution5 {
	public static ArrayList<String> arr;
	public static void dfs(String a, String[][] t, String r, int i, int n, boolean[] v) {
		a = a+r+" ";
		
		if(i==n) {
			arr.add(a);
		}
		
		
		for(int j=0;j<t.length;j++) {
			if(!v[j] && t[j][0].compareTo(r) == 0) {
				v[j] = true;
				dfs(a, t, t[j][1], i+1, n, v);
				v[j] = false;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		boolean[] visit = new boolean[tickets.length];
		arr = new ArrayList<String>();
		dfs("", tickets, "ICN", 0, tickets.length, visit);
		Collections.sort(arr);
		String[] answer = arr.get(0).split(" ");
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
			
		}
		System.out.println();
		
	}

}

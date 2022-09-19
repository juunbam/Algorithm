package ds.dfsbfs;
import java.util.ArrayList;
import java.util.HashMap;

class Node{
	int depth;
	int total;
	public Node(int depth, int total) {
		super();
		this.depth = depth;
		this.total = total;
	}
}
public class Solution1 {
	
	public static int bfs(int[] num, int t) {
		ArrayList<Node> q = new ArrayList<Node>();
		HashMap<String, Integer> visit = new HashMap<String, Integer>();
		q.add(new Node(0, num[0]));
		q.add(new Node(0, num[0]*-1));
		int cnt=0;
		while(!q.isEmpty()) {
			Node e = q.remove(0);
			visit.put(e.depth+" "+e.total, 1);
			if(e.depth==num.length-1) {
				if(e.total==t) {
					break;
				}
			}
			else {
				int depth = e.depth+1;
				int total = e.total+num[depth];
				if(!visit.containsKey(depth+" "+total))
					q.add(new Node(depth, e.total+num[depth]));
				total = e.total-num[depth];
				if(!visit.containsKey(depth+" "+total))
					q.add(new Node(depth, e.total-num[depth]));
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(bfs(numbers, target));
	}

}

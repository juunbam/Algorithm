package ds.dfsbfs;
import java.util.ArrayList;

public class Solution3 {
	public static boolean[] visit;
	public static int bfs(String[] w, String b, String t) {
		ArrayList<String> q = new ArrayList<String>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		q.add(b);
		d.add(0);
		while(!q.isEmpty()) {
			String tmp = q.remove(0);
			int dep = d.remove(0);
			if(tmp.compareTo(t) == 0) {
				return dep;
			}
			for(int i=0;i<w.length;i++) {
				if(!visit[i] && rules(tmp, w[i]) == 1) {
					q.add(w[i]);
					d.add(dep+1);
					visit[i]=true;
				}
			}
		}
		return 0;
	}
	public static int rules(String a, String b) {
		int cnt=0;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i) != b.charAt(i))
				cnt++;
		}
		return cnt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		int answer=0;
		boolean flag = false;
		for(int i=0;i<words.length;i++) {
			if(words[i].compareTo(target)==0){
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println(0);
		}
		else {
			visit = new boolean[words.length];
			answer = bfs(words,begin,target);
			System.out.println(answer);
		}
	}

}

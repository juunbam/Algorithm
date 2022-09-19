package ds.stackqueue;
import java.util.ArrayList;

class printList{
	int index;
	int pr;
	public printList(int index, int pr) {
		super();
		this.index = index;
		this.pr = pr;
	}
}
public class Solution2 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		ArrayList<printList> q = new ArrayList<printList>();
		
		int[] priority = new int[10];
		int mp = 0;
		for(int i=0;i<priorities.length;i++) {
			priority[priorities[i]]++;
			q.add(new printList(i, priorities[i]));
			if(priorities[i] > mp) 
				mp = priorities[i];
		}
		int answer = 0;
		while(true) {
			printList tmp = q.get(0);
			if(mp > tmp.pr) {
				q.add(q.remove(0));
			}
			else {
				tmp = q.remove(0);
				answer++;
				if(tmp.index == location)
					break;
				
				priority[mp]--;
				if(priority[mp] <= 0) {
					for(int i=mp;i>=0;i--) {
						if(priority[i] > 0) {
							mp = i;
							break;
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

}

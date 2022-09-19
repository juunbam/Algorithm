package ds.stackqueue;
import java.util.ArrayList;

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arrangement="()(((()())(())()))(())";
		ArrayList<String> stack = new ArrayList<String>();
		int answer = 0;
		for(int i=0;i<arrangement.length();i++) {
			String tmp = arrangement.substring(i,i+1);
			if(tmp.compareTo(")") == 0) {
				if(arrangement.substring(i-1, i).compareTo("(") == 0) {
					answer += stack.size()-1;
				}
				else {
					answer++;
				}
				stack.remove(stack.size()-1);
			}
			else {
				stack.add(tmp);
			}
		}
		System.out.println(answer);
	}

}

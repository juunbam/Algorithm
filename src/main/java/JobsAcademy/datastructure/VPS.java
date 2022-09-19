package JobsAcademy.datastructure;
import java.util.ArrayList;
import java.util.Scanner;

public class VPS {
	public static ArrayList<String> ps;
	public static void push(String a) {
		ps.add(a);
	}
	public static String pop() {
		return ps.remove(ps.size()-1);
	}
	public static String top() {
		return ps.get(ps.size()-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		ps = new ArrayList<String>();
		for(int i=0;i<input.length();i++) {
			String tmp = input.substring(i,i+1);
			if(tmp.compareTo(")") == 0) {
				if(ps.size() != 0) {
					pop();
				}
				else {
					push(tmp);
					break;
				}
			}
			else {
				push(tmp);
			}
		}
		if(ps.size()>0)
			System.out.println("NO");
		else
			System.out.println("YES");

	}

}

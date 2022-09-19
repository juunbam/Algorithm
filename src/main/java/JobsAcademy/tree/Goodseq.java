package JobsAcademy.tree;
import java.util.Scanner;

public class Goodseq {
	public static String Answer="";
	public static void goodNum(String a, int n, int i) {
		if(n==i) {
			if(Answer.isEmpty()) {
				Answer = a;
			}
		}
		else {
			if(Answer.isEmpty()) {
				if(goodSeq(a+"1"))
					goodNum(a+"1", n, i+1);
				if(goodSeq(a+"2"))
					goodNum(a+"2", n, i+1);
				if(goodSeq(a+"3"))
					goodNum(a+"3", n, i+1);
			}
		}
	}
	public static boolean goodSeq(String a) {
		String tmp = "";
		for(int i=0;i<a.length();i++) {
			tmp += a.charAt(i);
			if(tmp.length()==1)
				continue;
			else {
				for(int j=1;j<=tmp.length()/2;j++) {
					if(tmp.substring(tmp.length()-j, tmp.length()).compareTo(tmp.substring(tmp.length()-j*2, tmp.length()-j))==0)
						return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		goodNum("", n, 0);
		System.out.println(Answer);
	}

}

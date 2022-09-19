package JobsAcademy.tree;
import java.util.ArrayList;
import java.util.Scanner;

public class Dessert {
	public int cnt=0;
	public void dessert(String a, int n, int i) {
		if(n>i) {
			dessert(a+i+" + ", n, i+1);
			dessert(a+i+" - ", n, i+1);
			dessert(a+i+" . ", n, i+1);
		}
		else {
			a=a+n;	
			if(caculation(a, n) == 0) {
				cnt++;
				if(cnt < 20) {
				System.out.println(a);
				}
			}
		}
	}
	public long caculation(String a, int n) {
		long t=0;
		
		ArrayList<Long> num = new ArrayList<Long>();
		ArrayList<String> exp = new ArrayList<String>();
		int last = 0;
		a = a.replace(" ", "");
		a = a.replace(".", "");
//		System.out.println(a);
		for(int i=0;i<a.length()-1;i++) {
			String tmp = a.substring(i,i+1);
			if(tmp.compareTo("+") == 0 || tmp.compareTo("-") == 0) {
//				System.out.println(i-last);
				if((i-last) > 18) {
					return -1;
				}
				num.add(Long.parseLong(a.substring(last, i)));
				exp.add(tmp);
				last=i+1;
			}
		}
//		System.out.println(last+" "+a.length());
		if(a.length()-last > 18) {
			return -1;
		}
		num.add(Long.parseLong(a.substring(last,a.length())));
		
		t+=num.get(0);
		for(int i=0;i<exp.size();i++) {
			if(exp.get(i).compareTo("+") == 0) {
				t = t + num.get(i+1);
			}
			else {
				t = t - num.get(i+1);
			}
		}
		return t;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Dessert d = new Dessert();
		
		d.dessert("", N, 1);
		System.out.println(d.cnt);
	}

}

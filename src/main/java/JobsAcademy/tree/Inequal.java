package JobsAcademy.tree;
import java.util.ArrayList;
import java.util.Scanner;

public class Inequal {
	public static ArrayList<String> arr = new ArrayList<String>();
	public static void full(String[] eq, int[] s, int[] f, int n, int depth) {
		if(n==depth) {
			String a = "";
			for(int i=0;i<n;i++)
				a+=s[i];
			arr.add(a);
			return;
		}
		
		for(int i=0;i<f.length;i++) {
			if(f[i] == 1)
				continue;
			
		    if(depth>0) {
		    	if(equation(eq[depth-1], s[depth-1], i)) {
		    		f[i]=1;
				    s[depth]=i;
				    full(eq, s, f, n, depth+1);
				    f[i]=0;
		    	}
		    }
		    else {
		    	f[i]=1;
			    s[depth]=i;
			    full(eq, s, f, n, depth+1);
			    f[i]=0;
		    }
		}
	}
	public static boolean equation(String eq, int a, int b) {
		if(eq.compareTo("<")==0) {
			if(a<b) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if(a>b) {
				return true;
			}
			else {
				return false;
			}
		}
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] selected = new int[n+1];
		int[] flag = new int[10];
		
		String[] eq = new String[n];
		
		for(int i=0;i<n;i++) {
			eq[i] = sc.next();
		}
		full(eq, selected, flag, n+1, 0);
		System.out.println(arr.get(arr.size()-1));
		System.out.println(arr.get(0));
	}

}

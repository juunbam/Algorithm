package JobsAcademy.tree;
import java.util.ArrayList;
import java.util.Scanner;

public class chebyshevtheo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> input = new ArrayList<Integer>();
		
		int n=-1;
		while(n!=0) {
			n=sc.nextInt();
			if(n!=0)
				input.add(n);
		}

		for(int i=0;i<input.size();i++) {
			n=input.get(i);
			int cnt=0;
			for(int j=(n*2);j>n;j--) {
				boolean flag=true;
				int m = (int) Math.sqrt(j);
				for(int k=2;k<=m;k++) {
					if(j%k==0) {
						flag=false;
						break;
					}
				}
				if(flag)
					cnt++;
			}
			System.out.println(cnt);
		}
	}
}

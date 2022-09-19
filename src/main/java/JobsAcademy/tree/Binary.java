package JobsAcademy.tree;
import java.util.Scanner;

public class Binary {
	
	public static int pow(int n, int i) {
		int a=1;
		if(i==0)
			return a;
		for(int j=0;j<i;j++) 
			a*=n;
		return a;
	}
	public static int binary(int n, int i) {
		if(i==0) {
			if(n!=0)
				return 1;
			else
				return 0;
		}
		else {
			if(n/pow(2, i)==1) {
				return pow(10, i)+binary(n%pow(2, i), --i);
			}
			else
				return binary(n, --i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int Answer = 0;
		int i=0;
		while(N>=Binary.pow(2, i))
			i++;
		i--;
		
		System.out.println(binary(N,i));
	}

}

package test.samsung.practice;
import java.util.Scanner;

public class TA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		long total = 0;
		
		
		
		for(int i=0;i<N;i++) {
			arr[i] -= a;
			total++;
			if(arr[i]<=0) {
				continue;
			}
			else {
				total += (arr[i]/b);
				if(arr[i]%b != 0) {
					total++;
				}
			}
		}
		
		System.out.println(total);
		
		
	}

}

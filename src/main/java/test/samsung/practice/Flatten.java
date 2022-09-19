package test.samsung.practice;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Flatten {
	public static int Answer;
	
	public static void doDump(int[] num, int time) {
		for(int i=0;i<time;i++) {
			int max = getMax(num);
			int min = getMin(num);
			num[max]--;
			num[min]--;
			num[max-1]++;
			num[min+1]++;
		}
		Answer = getMax(num) - getMin(num);
	}
	public static int getMax(int[] num) {
		int m = 0;
		for(int i=num.length-1;i>0;i--) {
			if(num[i] > 0) {
				m = i;
				break;
			}
		}
		return m;
	}
	public static int getMin(int[] num) {
		int m = 0;
		for(int i=1;i<num.length;i++) {
			if(num[i] > 0) {
				m = i;
				break;
			}
		}
		return m;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("Input.txt"));
		
		int T = 10;
		for(int test_case=0;test_case<10;test_case++) {
			Answer = 0;
			int dump = sc.nextInt();
			int[] num = new int[101];
			for(int i=0;i<100;i++) {
				int h = sc.nextInt();
				num[h]++;
			}
			doDump(num, dump);
			
			System.out.println("#"+(test_case+1)+" "+Answer);
		}
	}

}

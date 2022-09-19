package test.samsung.practice;
import java.util.ArrayList;
import java.util.Scanner;

public class Gear {
	public static final int GN = 8;
	public static final int TN = 5;
	
	public static final int N=0, S=1;
	
	public static void process(ArrayList<ArrayList<Integer>> g, int[][] ro, int k) {
		for(int i=0;i<k;i++) {
			int index = ro[i][0];
			int d = ro[i][1];
			
			rotate(g, d, index);
		}
	}
	public static void rotate(ArrayList<ArrayList<Integer>> g, int rd, int i) {
		int[] d = new int[TN];
		int[] r = new int[TN];
		int[] l = new int[TN];
		
		for(int j=1;j<d.length;j++) {
			r[j] = g.get(j).get(2);
			l[j] = g.get(j).get(6);
		}
		d[i] = rd;
		boolean[] flag = new boolean[2];
		
		
		for(int j=i;j<TN-1;j++) {
			if(r[j] != l[j+1]) {
				d[j+1] = d[j]*-1;
			}
			else break;
		}
		for(int j=i;j>1;j--) {
			if(l[j] != r[j-1]) {
				d[j-1] = d[j]*-1;
			}
			else break;
		}
		
		
		for(int j=1;j<d.length;j++) {
			if(d[j] == 1) {
				int last = g.get(j).remove(7);
				g.get(j).add(0, last);
			}
			else if(d[j] == -1){
				int first = g.get(j).remove(0);
				g.get(j).add(first);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		ArrayList<ArrayList<Integer>> gears = new ArrayList<ArrayList<Integer>>();
		gears.add(new ArrayList<Integer>());
		
		for(int i=1;i<TN;i++) {
			gears.add(new ArrayList<Integer>());
			String line = sc.next();
			for(int j=0;j<GN;j++) {
				gears.get(i).add(Integer.parseInt(line.substring(j, j+1)));
			}
		}
		
		int K = sc.nextInt();
		int[][] r_order = new int[K][2];
		
		for(int i=0;i<K;i++) {
			for(int j=0;j<2;j++) {
				r_order[i][j] = sc.nextInt();
			}
		}
		
		process(gears, r_order, K);
		int Answer = 0;
		for(int i=1;i<TN;i++) {
			if(gears.get(i).get(0) == 1) {
				Answer += Math.pow(2, i-1);
			}
		}
		System.out.println(Answer);
	}

}

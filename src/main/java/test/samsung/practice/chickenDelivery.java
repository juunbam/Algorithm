package test.samsung.practice;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Loc {
	int x;
	int y;
	public Loc(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
public class chickenDelivery {
	public static int Answer;
	public static int total;
	public static int distance(int r1, int c1, int r2, int c2) {
		return (r1>r2?r1-r2:r2-r1)+(c1>c2?c1-c2:c2-c1);
	}
	public static void getMindist(Stack<Loc> s, ArrayList<Loc> h, ArrayList<Loc> c, int M, int i, int index) {
		if(M == i) {
			for(int k=0;k<h.size();k++) {
				int r1 = h.get(k).x;
				int c1 = h.get(k).y;
				int min = 999999999;
				for(int j=0;j<s.size();j++) {
					int r2 = s.get(j).x;
					int c2 = s.get(j).y;
					int dist = distance(r1,c1,r2,c2);
					if(dist < min)
						min = dist;
				}
				total += min;
			}
			if(Answer > total) {
				Answer = total;
			}
			total = 0;
		}
		
		if(index < c.size()) {
			s.push(c.get(index));
			getMindist(s, h, c, M, i+1, index+1);
			s.pop();
			getMindist(s, h, c, M, i, index+1);
		}
	}
//	public static int process(ArrayList<Loc> h, ArrayList<Loc> c, int M) {
//		
//	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] map = new int[N][N];
		
		ArrayList<Loc> house = new ArrayList<Loc>();
		ArrayList<Loc> chicken = new ArrayList<Loc>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					house.add(new Loc(i, j));
				}
				if(map[i][j] > 1) {
					chicken.add(new Loc(i, j));
				}
			}
		}
		total = 0;
		Answer = 99999999;
		getMindist(new Stack<Loc>(), house, chicken, M, 0, 0);
		System.out.println(Answer);
		
	}

}

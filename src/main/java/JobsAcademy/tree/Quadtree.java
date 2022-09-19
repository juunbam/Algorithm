package JobsAcademy.tree;
import java.util.ArrayList;
import java.util.Scanner;
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
public class Quadtree {
	public static String qt;
	public static int[][] arr;
	public static int[][] depth;
	public static int N;

	public static void quadtree(int x, int y, int n) {
		int f = 0;
		boolean flag = false;
		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(i == x && j == y) {
					f = arr[i][j];
				}
				else {
					if(f != arr[i][j]) {
						flag = true;
						break;
					}
				}
			}
			if(flag) {
				break;
			}
		}
		
		if(flag) {
			
		}
	}
	public static void bfs() {
		ArrayList<Point> q = new ArrayList<Point>();
		q.add(new Point(0,0));
		int n = 0;
		depth[0][0] = N;
		qt="";
		
		boolean[] flag = new boolean[4];
		while(!q.isEmpty()) {
			Point p = q.remove(0);
			n=depth[p.x][p.y]/2;

			//1
			String tmp="";
			int f = 0;
			flag[0] = true;
			for(int i=p.x;i<p.x+n;i++) {
				for(int j=p.y;j<p.y+n;j++) {
					if(i == p.x && j == p.y) {
						f = arr[i][j];
					}
					else {
						if(f != arr[i][j]) {
							tmp+="1";
							q.add(new Point(p.x, p.y));
							depth[p.x][p.y] = depth[p.x][p.y]/2; 
							flag[0] = false;
							break;
						}
					}
				}
				if(!flag[0])
					break;
			}
			if(flag[0]) 
				tmp=tmp+"0"+f;

			//2
			flag[1] = true;
			for(int i=p.x;i<p.x+n;i++) {
				for(int j=p.y+n;j<p.y+n+n;j++) {
					if(i == p.x && j == p.y+n) {
						f = arr[i][j];
					}
					else {
						if(f != arr[i][j]) {
							tmp+="1";
							q.add(new Point(p.x, p.y+n));
							depth[p.x][p.y+n] = depth[p.x][p.y]/2;
							flag[1] = false;
							break;
						}
					}
				}
				if(!flag[1])
					break;
			}
			if(flag[1]) 
				tmp=tmp+"0"+f;


			//3
			flag[2] = true;
			for(int i=p.x+n;i<p.x+n+n;i++) {
				for(int j=p.y;j<p.y+n;j++) {
					if(i == p.x+n && j == p.y) {
						f = arr[i][j];
					}
					else {
						if(f != arr[i][j]) {
							tmp+="1";
							q.add(new Point(p.x+n, p.y));
							depth[p.x+n][p.y] = depth[p.x][p.y]/2;
							flag[2] = false;
							break;
						}
					}
				}
				if(!flag[2])
					break;
			}
			if(flag[2]) 
				tmp=tmp+"0"+f;

			//4
			flag[3] = true;
			for(int i=p.x+n;i<p.x+n+n;i++) {
				for(int j=p.y+n;j<p.y+n+n;j++) {
					if(i == p.x+n && j == p.y+n) {
						f = arr[i][j];
					}
					else {
						if(f != arr[i][j]) {
							tmp+="1";
							q.add(new Point(p.x+n, p.y+n));
							depth[p.x+n][p.y+n] = depth[p.x][p.y]/2;
							flag[3] = false;
							break;
						}
					}
				}
				if(!flag[3])
					break;
			}
			if(flag[3]) 
				tmp=tmp+"0"+f;
			if(n * 2 == N) {
				for(int i=0;i<4;i++) {
					if(flag[i] == false) {
						tmp = "1" + tmp;
						break;
					}
				}
			}
			qt = qt+tmp;
		}
	}
	public static String twotosixteen(String a) {
		String st = "";
		for(int i=a.length();i>0;i=i-4) {
			String tmp = a.substring((i-4>0?i-4:0), i);
			if(tmp.length() != 4) {
				int n=tmp.length();
				for(int j=0;j<4-n;j++) {
					tmp = "0"+tmp;
				}
			}
			int n = binary(tmp);
			if(n > 9) {
				if(n == 10) {
					st = "A"+st;
				}
				else if(n == 11) {
					st = "B"+st;
				}
				else if(n == 12) {
					st = "C"+st;		
				}
				else if(n == 13) {
					st = "D"+st;
				}
				else if(n == 14) {
					st = "E"+st;
				}
				else if(n == 15) {
					st = "F"+st;
				}
			}
			else {
				st = n+st;
			}

		}
		return st;
	}
	public static int binary(String a) {
		int n = 0;
		for(int i=3;i>=0;i--) {
			if(a.substring(i, i+1).compareTo("1") == 0)
				n += Math.pow(2, 3-i);
		}
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		arr = new int[N][N];
		depth = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(sc.hasNextInt())
					arr[i][j] = sc.nextInt();
			}
		}
		bfs();
		String t = twotosixteen(qt);
		if(Long.parseLong(t, 16) == 0)
			System.out.println(0);
		else
			System.out.println(t);
	}

}

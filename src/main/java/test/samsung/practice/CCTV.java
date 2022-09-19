package test.samsung.practice;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//class Point{
//	int x;
//	int y;
//	int type;
//	public Point(int x, int y, int type) {
//		super();
//		this.x = x;
//		this.y = y;
//		this.type = type;
//	}
//}
//public class CCTV {
//	public static final int U=0, L=1, D=2, R=3;
//	public static int[][][] t = {{},{{U}, {L}, {D}, {R}},{{U, D},{L, R}},{U, R},{U, L, R},{U, L, D, R}};
//	public static int[][] dir = {{-1, 0},{0, -1},{1, 0},{0, 1}};
//	
//	public static int findDeadzone(int[][] map) {
//		int cnt = 0;
//		for(int i=0;i<map.length;i++) {
//			for(int j=0;j<map[i].length;j++) {
//				if(map[i][j] == 0) {
//					cnt++;
//				}
//			}
//		}
//		return cnt;
//	}
//	public static void checkVisiblezone(int[][] map, ArrayList<Point> c, boolean[][] w) {
//		for(int i=0;i<c.size();i++) {
//			Point p = c.get(i);
//			int x = p.x;
//			int y = p.y;
//			int type = p.type;
//			
//			int max = 0;
//			int index = -1;
//			for(int j=0;j<4;j++) {
//				int[] d = t[type];
//				int m = 0;
//				for(int k=0;k<d.length;k++) {
//					d[k]+=j;
//					x+=dir[d[k]][0];
//					y+=dir[d[k]][1];
//					while(x >= 0 && x < map.length && y >= 0 && y < map[0].length) {
//						if(w[x][y])
//							break;
//						else if(map[x][y] == 0){
//							m++;
//						}
//					}
//				}
//				if(max < m) {
//					index = j;
//					max = m;
//				}
//			}
//			System.out.println(index+" "+max);
//			int[] d = t[type];
//			for(int j=0;j<d.length;j++) {
//				d[j]+=index;
//				x+=dir[d[j]][0];
//				y+=dir[d[j]][1];
//				while(x >= 0 && x < map.length && y >= 0 && y < map[0].length) {
//					if(w[x][y])
//						break;
//					else if(map[x][y] == 0){
//						map[x][y] = -1;
//					}
//				}
//			}
//		}
//	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//		
//		int[][] map = new int[N][M];
//		ArrayList<Point> cctv = new ArrayList<>();
//		boolean[][] wall = new boolean[N][M];
//		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				int value = sc.nextInt();
//				map[i][j] = value;
//				if(value > 0 && value < 6) {
//					cctv.add(new Point(i, j, value));
//				}
//				else if(value == 6) {
//					wall[i][j] = true;
//				}
//			}
//		}
//		checkVisiblezone(map, cctv, wall);
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				System.out.println(map[i][j]);
//			}
//		}
//		
//	}
//
//}

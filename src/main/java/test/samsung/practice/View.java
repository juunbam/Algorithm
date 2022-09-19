package test.samsung.practice;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class View {
//	public static int Answer;
//	public static int getLastbuilding(int[] height, int i) {
//		int[] temp = new int[5];
//		for(int j=0;j<5;j++) {
//			temp[j] = height[i+j-2];
//		}
//		
//		Arrays.sort(temp);
//		
//		if(temp[temp.length-1] == height[i]) {
//			if(temp[temp.length-2] <height[i]) {
//				Answer += (height[i]-temp[temp.length-2]);
//				return i+2;
//			}
//		}
//		return i;
//	}
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(new FileInputStream("input.txt"));
//		
//		int T = sc.nextInt();
//		for(int test_case=0;test_case<T;test_case++) {
//			Answer = 0;
//			int N = sc.nextInt();
//			
//			int[] height = new int[N];
//			
//			for(int i=0;i<N;i++) {
//				height[i] = sc.nextInt();
//			}
//			
//			for(int i=2;i<N-2;i++) {
//				int index = getLastbuilding(height, i);
//				i=index;
//			}
//			
//			System.out.println("#"+(test_case+1)+" "+Answer);
//		}
//	}
//
//}

package test.samsung.practice;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class Palindrome {
	public static int Answer;
	public static boolean isPalindrome(int[][] map, int x, int y, int d, int len) {
		if(d == 0) {
			for(int i=0;i<=(len/2);i++) {
				if(map[x][i] != map[x][y+len-i-1])
					return false;
			}
		}
		else {
			for(int i=y;i<=((y+len)/2);i++) {
				if(map[i][x] != map[y+len-i-1][x])
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		int T = 1;
		
		for(int test_case=0;test_case<T;test_case++) {
			Answer = 0;
			int len = sc.nextInt();
			int n=8;
			int[][] map = new int[n][n];
			for(int i=0;i<n;i++) {
				String input = sc.next();
				for(int j=0;j<n;j++) {
					map[i][j] = input.charAt(j);
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<=(n-len);j++) {
					if(isPalindrome(map, i, j, 0, len)) {
						Answer++;
					}
					if(isPalindrome(map, i, j, 1, len)) {
						Answer++;
					}
				}
			}
			
			
			System.out.println("#"+(test_case+1)+" "+Answer);
		}
	}

}

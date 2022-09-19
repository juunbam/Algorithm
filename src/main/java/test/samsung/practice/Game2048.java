package test.samsung.practice;
import java.util.Scanner;
import java.util.Stack;

public class Game2048 {
	public static final int U=0, R=1, D=2, L=3;
	public static void dfs(Stack<Integer> s, int i, int index, int n) {
		if(i<n && index<4) {
			s.push(index);
			dfs(s, i+1, index, n);
			s.pop();
			dfs(s, i, index+1, n);
		}
		
		if(i==n) {
			System.out.println(s.toString());
		}
	}
	
	public static void pushDirection(int d, int n) {
		int s=0, l=0;
		
		switch(d) {
		case U:
			
			break;
		case R:
			break;
		case D:
			break;
		case L:
			break;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		dfs(new Stack<Integer>(), 0, 0, 5);
	}

}

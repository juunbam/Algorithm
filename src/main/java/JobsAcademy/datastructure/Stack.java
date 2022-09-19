package JobsAcademy.datastructure;

import java.util.Scanner;

public class Stack {
 	public static int[] s;
 	public static int n;
 	public static int inx;
 	public static void push(int x) {
 		s[inx] = x;
 		inx++;
 	}
 	
 	public static void pop() {
 		s[inx-1]=0;
 		inx--;
 	}
 	public static int top() {
 		return s[inx-1];
 	}
 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        
		n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] command = new int[m][2];
		for(int i=0;i<m;i++) {
			int c = sc.nextInt();
			command[i][0] = c;
			if(c == 1)
				command[i][1] = sc.nextInt();
		}
		
		s = new int[n];
		inx = 0;
		for(int i=0;i<m;i++) {
			switch(command[i][0]) {
			case 1:
				if(inx >= n)
					System.out.println("Overflow");
				else 
					push(command[i][1]);
				break;
			case 2:
				if(inx<=0) 
					System.out.println("Underflow");
				else 
					pop();
				break;
			case 3:
				if(inx<=0)
					System.out.println("NULL");
				else
					System.out.println(top());
				break;
			}
		}
		
		
	}

}

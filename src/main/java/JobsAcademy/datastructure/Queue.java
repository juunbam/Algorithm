package JobsAcademy.datastructure;
import java.util.Scanner;

public class Queue {
	public static int[] q;
	public static int n;
	public static int front;
	public static int rear;
	public static void push(int x) {
		q[rear] = x;
		rear++;
	}
	public static void pop() {
		q[front++] = 0;
	}
	public static int top() {
		return q[front];
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
		
		q = new int[n];
		front = 0;
		rear = 0;
		
		for(int i=0;i<m;i++) {
			switch(command[i][0]) {
			case 1:
				if(rear>=n)
					System.out.println("Overflow");
				else
					push(command[i][1]);
				break;
			case 2:
				if(front>=rear)
					System.out.println("Underflow");
				else
					pop();
				break;
			case 3:
				if(front>=rear)
					System.out.println("NULL");
				else
					System.out.println(top());
				break;
			}
		}
	}

}

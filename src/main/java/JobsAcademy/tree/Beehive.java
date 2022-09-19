package JobsAcademy.tree;
import java.util.Scanner;

public class Beehive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int Answer = 1;
		int last = 1;
		while(n>last){
			last = last + (6 * Answer++);
		}
		
		System.out.println(Answer);
	}

}

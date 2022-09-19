package JobsAcademy.tree;
import java.util.ArrayList;
import java.util.Scanner;

public class Color {
	public static int Nv;
	public static int Ne;
	public static int[][] nodes;
	public static int[] vcolor;
	public static String answer = "No";
	public static boolean check = false;
	
	public static void m_coloring(int m, int i){
		int color = 0;
		if(check == true)
			return;
		if(promising(i)) {
			if(i==Nv-1) {
				check = true;
			}
			else {
				for(color = 1;color<=m;color++) {
					vcolor[i+1] = color;
					m_coloring(m, i+1);
				}
			}
		}
	}
	public static boolean promising(int i) {
		int j=1;
		
		while(j<i) {
			if(nodes[i][j] == 1 && vcolor[i] == vcolor[j]) {
				return false;
			}
			j++;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		Nv = input.nextInt()+1;
		Ne = input.nextInt();
		nodes = new int[Nv][Nv];
		vcolor = new int[Nv];
		
		for(int i=0;i<Ne;i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			
			nodes[a][b] = 1;
			nodes[b][a] = 1;
		}
		
		if(check == true)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}

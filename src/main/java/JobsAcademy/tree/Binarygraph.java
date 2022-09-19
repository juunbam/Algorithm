package JobsAcademy.tree;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Binarygraph {
    public static int Nv;
    public static int Ne;
    public static int[][] nodes;
    public static int[] vcolor;
    public static int color;
    public static boolean check = true;
    public static boolean bfs(int r) {
        check = true;
        ArrayList<Integer> q = new ArrayList<Integer>();
        q.add(r);
        vcolor[r] = color;
        while(!q.isEmpty() && check) {
            int tmp = q.remove(0);
            for(int i=1;i<Nv;i++) {
                if(nodes[tmp][i] == 1) {
                    if(vcolor[i] == 0) {
                        vcolor[i] = 3-vcolor[tmp];
                        q.add(i);
                    }
                    else {
                        if(vcolor[tmp] == vcolor[i]) {
                            check = false;
                            break;
                        }
                    }
                }
            }
        }
        return check;
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
        color = 1;
        for(int i=0;i<Nv;i++)
            vcolor[i] = 0;
        
        for(int i=1;i<Nv;i++) {
            if(vcolor[i] == 0) {
                check = bfs(i);
                if(check == false) {
                	break;
                }
            }
        }
        
        
        if(check == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
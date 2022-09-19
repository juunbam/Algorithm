package JobsAcademy.tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfsdfs {
	 static int Nv;
	    static int Ne;
	    static boolean[] visit;
	    static ArrayList<ArrayList<Integer>> ad;
	    static int cnt=0;
	    public static void dfs(int i){
	        visit[i] = true;
	        System.out.printf("%c ",(i+65));
	        Collections.sort(ad.get(i));
	        for(int j : ad.get(i)){  // Î∞∞Ïó¥ null check
	            if(visit[j] == false){
	                dfs(j);
	            }
	        }
	    }
	    public static void bfs(int i) {
	    	ArrayList<Integer> q = new ArrayList<Integer>();
	    	q.add(i);
	    	visit[i] = true;
	    	Collections.sort(q);
	    	while (!q.isEmpty()) {
	    		i = q.remove(0);
	    		System.out.printf("%c ",(i+65));
	    		Collections.sort(ad.get(i));
	    		for(int j : ad.get(i)){
	    			if (visit[j] == false) {
	    				q.add(j);
	    				visit[j] = true;
    				} 
    			} 
    		} 
    	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        Nv = sc.nextInt();
        Ne = sc.nextInt();
        ad = new ArrayList<ArrayList<Integer>>(Nv); // ?ù∏?†ë Î¶¨Ïä§?ä∏ Ï¥àÍ∏∞?ôî
        visit = new boolean[Nv]; // visit Î∞∞Ïó¥ Ï¥àÍ∏∞?ôî
        
        for(int i = 0; i < Nv; i++){ // ?ù∏?†ë Î¶¨Ïä§?ä∏ ?Üç?ùò Î¶¨Ïä§?ä∏ Ï¥àÍ∏∞?ôî
        	ArrayList<Integer> tmp = new ArrayList<Integer>();
            ad.add(tmp);
        }
        
        for(int i = 0; i < Ne; i++){
            String t1 = sc.next();
            String t2 = sc.next();
            int a = t1.charAt(0)-65;
            int b = t2.charAt(0)-65;
            
            ad.get(a).add(b);
            ad.get(b).add(a);
        }
        
        String a = sc.next();
        int root = a.charAt(0)-65;
        
        dfs(root);
        System.out.println();
        
        for(int i=0;i<Nv;i++)
        	visit[i] = false;
        bfs(root);
        
//        System.out.println(ad.toString());

	}

}

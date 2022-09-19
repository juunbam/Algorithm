package JobsAcademy.tree;
import java.util.ArrayList;
import java.util.Scanner;

public class treeDepth {
 	static int Nv;
    static int Ne;
    static int r;
    static int[] d;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> ad;
    static ArrayList<ArrayList<Integer>> par;
    static int cnt=0;
    
    public static void dfs(int i, int parent, int root){
        visit[i] = true;
        
        if(i == root) {
        	d[i] = 0;
        } else {
        	d[i]=d[parent]+1;
        	par.get(i).add(parent);
        }
        if(d[i]>1) {
        	for(int j=1;j<d[i];j++) {
        		int tmp = par.get(i).get(j-1);
        		if(j-1<par.get(tmp).size())
        			par.get(i).add(par.get(tmp).get(j-1));
        	}
        	
        }
        
        for(int j : ad.get(i)){  // Î∞∞Ïó¥ null check
            if(visit[j] == true)
            	continue;
            dfs(j, i, root);
            
        }
    }
    
    public static int lca(int a, int b) {
    	if (d[a] != d[b])
        {
            if (d[a] > d[b]) {
                int tmp = a;
                a = b;
                b = tmp;
            }
 
            for (int i = par.get(b).size()-1; i >= 0; i--)
            {
                if (d[a] <= d[par.get(b).get(i)])
                    b = par.get(b).get(i);
            }
        }
 
        int lca = a;
 
        if (a != b)
        {
            for (int i = par.get(a).size()-1; i >= 0; i--)
            {
                if (par.get(a).get(i) != par.get(b).get(i))
                {
                    a = par.get(a).get(i);
                    b = par.get(b).get(i);
                }
                lca = par.get(a).get(i);
            }
        }
        return lca;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        Nv = sc.nextInt();
        Ne = Nv-1;
        
        r = 0;
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        ad = new ArrayList(Nv); // ?ù∏?†ë Î¶¨Ïä§?ä∏ Ï¥àÍ∏∞?ôî
        par = new ArrayList(Nv);
        visit = new boolean[Nv]; // visit Î∞∞Ïó¥ Ï¥àÍ∏∞?ôî
        d = new int[Nv+1];
        
        for(int i = 0; i < Nv; i++){ // ?ù∏?†ë Î¶¨Ïä§?ä∏ ?Üç?ùò Î¶¨Ïä§?ä∏ Ï¥àÍ∏∞?ôî
            ad.add(new ArrayList());
            par.add(new ArrayList());
        }
        
        for(int i = 0; i < Ne; i++){
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            
            ad.get(t1).add(t2);
            ad.get(t2).add(t1);
        }
        
        dfs(r, 0, 0);
        System.out.println(lca(a,b));
        

	}

}

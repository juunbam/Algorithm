package JobsAcademy.tree;
import java.util.ArrayList;
import java.util.Scanner;

public class commonParent {
 	static int Nv;
    static int Ne;
    static int r;
    static int[] d;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> ad;
    static ArrayList<ArrayList<Integer>> par;
    static int cnt=0;
    public static double logB(double x, double base) {
        return Math.log(x) / Math.log(base);
    }
    public static void dfs(int i, int parent, int root){
        visit[i] = true;
        
        if(i == root) {
        	d[i] = 0;
        } else {
        	d[i]=d[parent]+1;
        	par.get(i).add(parent);
        }
        if(d[i]>1) {
        	int n = (int) logB(d[i],2.0);
        	for(int j=1;j<=n;j++) {
        		int tmp = par.get(i).get(j-1);	
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
    	if(a==b)
    		return a;
    	if (d[a] != d[b])
        {
            if (d[a] > d[b]) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            
            int inx=1;
            while(d[a] < d[b]) {
            	if(d[a] <= d[par.get(b).get(par.get(b).size()-inx)]) {
            			b = par.get(b).get(par.get(b).size()-inx);
            			inx=1;
            	}
            	else
            		inx++;
            }
        }
 
        int lca = a;
        if (a != b)
        {
        	boolean flag = true;
        	int inx = 1;
        	while(flag) {
        		int dp = par.get(a).size();
        		if(dp == inx)
        			flag = false;
        		if(par.get(a).get(dp-inx) != par.get(b).get(dp-inx)) {
        			a=par.get(a).get(dp-inx);
        			b=par.get(b).get(dp-inx);
        			inx = 1;
        		}
        		else {
        			lca = par.get(a).get(dp-inx);
        			inx++;
        		}
        		
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
        
        ad = new ArrayList<ArrayList<Integer>>(Nv); // ?ù∏?†ë Î¶¨Ïä§?ä∏ Ï¥àÍ∏∞?ôî
        par = new ArrayList<ArrayList<Integer>>(Nv);
        visit = new boolean[Nv]; // visit Î∞∞Ïó¥ Ï¥àÍ∏∞?ôî
        d = new int[Nv];
        if(Nv == 1) {
        	System.out.println(0);
        	return;
        }
        for(int i = 0; i < Nv; i++){ // ?ù∏?†ë Î¶¨Ïä§?ä∏ ?Üç?ùò Î¶¨Ïä§?ä∏ Ï¥àÍ∏∞?ôî
        	ArrayList<Integer> tmp = new ArrayList<Integer>();
        	ad.add(tmp);
        }
        for(int i = 0; i < Nv; i++){ // ?ù∏?†ë Î¶¨Ïä§?ä∏ ?Üç?ùò Î¶¨Ïä§?ä∏ Ï¥àÍ∏∞?ôî
        	ArrayList<Integer> tmp = new ArrayList<Integer>();
        	par.add(tmp);
        }
        
        for(int i = 0; i < Ne; i++){
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            
            ad.get(t1).add(t2);
            ad.get(t2).add(t1);
        }
        
        dfs(r, 0, 0);
        int lca = lca(a,b);
        System.out.println(lca);
        

	}

}

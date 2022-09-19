package ds.hash;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution3 {
	public static int total = 0;
	public static ArrayList<Integer> arr;
	public static void doCombination(int n, int r, int index, int target, int t){
        if(r == 0){
            total+=t;
        }
        else {
        	if(target+1<=n) {
	            t *= arr.get(target);
	            doCombination(n, r-1, index+1, target+1, t);
	            t /= arr.get(target);
	            doCombination(n, r, index, target+1, t); 
        	}
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = {{"yellow_hat", "h"},{"yellow_hat", "d"},{"yellow_hat", "d"},{"yellow_hat", "h"}};
		int answer = 1;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0;i<clothes.length;i++) 
			if(map.containsKey(clothes[i][1])) map.replace(clothes[i][1], map.get(clothes[i][1])+1);
			else map.put(clothes[i][1], 1);
		
		for(String key:map.keySet()) 
			answer *= (map.get(key)+1);
		System.out.println(answer-1);
		
	}

}

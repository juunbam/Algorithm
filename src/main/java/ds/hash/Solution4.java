package ds.hash;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class Node {
	String genre;
	int plays;
	public Node(String genre, int plays) {
		super();
		this.genre = genre;
		this.plays = plays;
	}
}
public class Solution4 {
	private static Map<Integer, Integer> sortByComparator(Map<Integer, Integer> unsortMap, final boolean order) {
		List<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(unsortMap.entrySet());
		// Sorting the list based on values
		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				if (order) 
					return o1.getValue() >= o2.getValue()? 1:-1;
				else 
					return o1.getValue() <= o2.getValue()? 1:-1;
			}
		});
		Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
		for (Entry<Integer, Integer> entry : list) 
			sortedMap.put(entry.getKey(), entry.getValue());
		

		return sortedMap;
	}
	private static Map<String, Integer> sortByComparator2(Map<String, Integer> unsortMap, final boolean order) {
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());
		// Sorting the list based on values
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if (order) 
					return o1.getValue() >= o2.getValue()? 1:-1;
				else 
					return o1.getValue() <= o2.getValue()? 1:-1;
			}
		});
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Entry<String, Integer> entry : list) 
			sortedMap.put(entry.getKey(), entry.getValue());
		

		return sortedMap;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] genres = {"pop","classic","pop","R&B", "R&B"};
		int[] plays = {2500, 600, 500, 600, 150};
		HashMap<String, Map<Integer, Integer>> map = new HashMap<String, Map<Integer, Integer>>();
		Map<String, Integer> t = new LinkedHashMap<String, Integer>();
		
		for(int i=0;i<genres.length;i++) {
			if(map.containsKey(genres[i])) {
				map.get(genres[i]).put(i, plays[i]);
			}
			else {
				Map<Integer, Integer> tmp = new LinkedHashMap<Integer, Integer>();
				tmp.put(i, plays[i]);
				map.put(genres[i], tmp);
			}
			
			if(t.containsKey(genres[i])) t.put(genres[i], t.get(genres[i])+plays[i]);
			else t.put(genres[i], plays[i]);
		}
		for(String key:map.keySet()) {
			map.replace(key, sortByComparator(map.get(key), false));
		}
		t = sortByComparator2(t, false);
		ArrayList<Integer> a = new ArrayList<Integer>();
		int n = t.size();
		for(String key:t.keySet()) {
			Map<Integer, Integer> tmp = map.get(key);
			int j=0;
			for(int k:tmp.keySet()) {
				if(j<2) { j++; a.add(k); }
				else { break; }
			}
		}
		int[] answer = new int[a.size()];
		for(int i=0;i<a.size();i++) {
			answer[i] = a.get(i);
		}
//		
//		TreeMap<String, Integer> t = new TreeMap<>(Collections.reverseOrder());
//
//		for(int i=0;i<genres.length;i++) 
//			if(t.containsKey(genres[i])) t.put(genres[i], t.get(genres[i])+plays[i]);
//			else t.put(genres[i], plays[i]);
//
//		List<Integer> l = new ArrayList<>();
//		for(String key:t.keySet()) {
//			HashMap<Integer, Integer> tmp = new HashMap<>();
//			for(int i=0;i<genres.length;i++) {
//				if(genres[i].compareTo(key)==0) {
//					tmp.put(i, plays[i]);
//				}
//			}
//			Iterator it = sortByValue(tmp).iterator();
//			int j=0;
//			while(it.hasNext()) {
//				if(j<2) {
//					j++;
//					l.add((Integer) it.next());
//				}
//				else break;
//			}
//
//		}
//		int[] answer = new int[l.size()];
//		for(int i=0;i<answer.length;i++) 
//			answer[i] = l.get(i);


	}

}

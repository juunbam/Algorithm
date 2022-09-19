package test.hancom;
import java.util.HashMap;

public class Solution2 {
	public static boolean exceedingTime(int[][] input) {
		int day_limit = 40;
		int night_limit = 12;

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for(int i=0;i<input.length;i++) {
			String key = input[i][0]+" "+input[i][1];
			if(map.containsKey(key)) map.replace(key, map.get(key)+1);
			else map.put(input[i][0]+" "+input[i][1], 1);
		}
		int day_time = 0;
		int night_time = 0;

		for(String key:map.keySet()) {
			String[] day = key.split(" ");
			int num = map.get(key);
			int start = Integer.parseInt(day[0]);
			int end = Integer.parseInt(day[1]);
			if(start >= 6 && (end <= 19 && end >= 6)) {
				day_time += ((end - start) * num);
				continue;
			}
			if(start < 6 && (end <= 19 && end >= 6)) {
				night_time += ((6 - start) * num);
				day_time += ((end - 6) * num);
				continue;
			}
			if((end > 19 || end < 6) && start >= 6) {
				day_time += ((19-start) * num);
				night_time += ((((end >= 0 && end <= 6)?end+24:end) - 19) * num);
				continue;
			}
			if((end > 19 || end < 6) && start < 6) {
				night_time += ((6-start) * num);
				day_time += ((19-6) * num);
				night_time += ((((end >= 0 && end <= 6)?end+24:end) - 19) * num);
				continue;
			}
		}
		if(day_time > day_limit || night_time > night_limit) return true;
		else return false;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {{9, 19}, {9, 19}};
		System.out.println(exceedingTime(input));
	}

}

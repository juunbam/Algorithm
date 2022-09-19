package ds.hash;
import java.util.HashMap;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] phone_book = {"12","123","1235","567","88"};
		
		HashMap<String,String> a = new HashMap<String, String>();
		
		for(int i=0;i<phone_book.length;i++) {
			a.put(phone_book[i], phone_book[i]);
		}
		
		boolean flag=true;
		for(int i=0;i<phone_book.length;i++) {
			for(String key:a.keySet()) {
				if(phone_book[i].compareTo(key)!=0) {
					if(phone_book[i].length() < key.length()) {
						if(phone_book[i].compareTo(key.substring(0, phone_book[i].length()))==0) {
							flag = false;
							break;
						}
					}
				}
			}
			if(!flag)
				break;
		}
		
	}

}

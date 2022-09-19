package test.hancom;
import java.util.ArrayList;

public class Solution1 {
	public static boolean isValidXML(String xml) {
		boolean v = false;
		ArrayList<String> stack = new ArrayList<String>();
		String[] list = xml.split("<");
		String doc = list[1].split(">")[0];
		String c_doc = list[list.length-1].split(">")[0];
		if(doc.compareTo("document") != 0 && c_doc.compareTo("/document") != 0)
			return false;
		boolean body_f = false;
		for(int i=2;i<list.length-1;i++) {
			String tmp = list[i].split(">")[0];
			System.out.println(tmp+" "+stack.toString());
			if(stack.isEmpty()) {
				if(tmp.compareTo("body") == 0 || tmp.compareTo("header") == 0 || tmp.compareTo("footer") == 0) {
					stack.add(tmp);
					if(tmp.compareTo("body") == 0) {
						body_f = true;
					}
				}
				else {
					return false;
				}
			}
			else {
				if(body_f) {
					if(tmp.compareTo("header") == 0 || tmp.compareTo("footer") == 0 || tmp.compareTo("/header") == 0 || tmp.compareTo("/footer") == 0)
						return false;
					if(stack.get(stack.size()-1).compareTo("body") == 0){
						if(tmp.compareTo("p") == 0 || tmp.compareTo("br") == 0) {
							stack.add(tmp);
						}
						else if(tmp.compareTo("/body") == 0) {
							stack.remove(stack.size()-1);
							body_f = false;
						}
						else if(tmp.compareTo("/br") == 0) {
							continue;
						}
						else {
							return false;
						}
					}
					else {
						if(stack.get(stack.size()-1).compareTo(tmp.substring(1, tmp.length())) == 0){
							stack.remove(stack.size()-1);
						}
						else {
							return false;
						}
					}
				}
				else {
					if(tmp.compareTo("p") == 0 || tmp.compareTo("br") == 0 || tmp.compareTo("/p") == 0 || tmp.compareTo("/br") == 0)
						return false;
					if(stack.get(stack.size()-1).compareTo(tmp.substring(1, tmp.length())) == 0){
						stack.remove(stack.size()-1);
					}
					else {
						return false;
					}
				}
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String xml = "<document>\n" +
				"</header>?���?�? 컴퓨?��\n" +
				"<body>\n" +
				"<p>?��컴오?��?�� 2018</p>\n" +
				"<br></br>\n" +
				"<header></header>" +
				"<p>?��?��?��?�� 기능?���? 말로 문서�? ?��?��?���?</p>\n" +
				"</br>\n" +
				"<p>모바?���? pc�? ?��?��?���? ?��?���? ?��집을 ?��?�� ?��?��</p>\n" +
				"</br>\n" +
				"<p>?��컴오?��?�� 2018?�� 만나보세?��.</p>\n" +
				"</body>\n" +
				"<footer>2018-10-09</footer>\n" +
				"</document>";
		System.out.println(isValidXML(xml));
	}

}

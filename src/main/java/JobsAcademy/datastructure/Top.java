package JobsAcademy.datastructure;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class topNode {
	int index;
	int height;
	public topNode(int index, int height) {
		super();
		this.index = index;
		this.height = height;
	}
}
public class Top {
	public static ArrayList<topNode> arr;
	public static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new ArrayList<topNode>();
		for(int i=0;i<n;i++) 
			arr.add(new topNode(i, sc.nextInt()));
		
		Collections.sort(arr,new Comparator<topNode>(){ // ?µëª? ?´?˜?Š¤ë¡? êµ¬í˜„
			public int compare(topNode o1, topNode o2) { // override
				return o1.height < o2.height ? -1 : (o1.height == o2.height ? 0 : 1);
			}
		});
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i).height+" "+arr.get(i).index);
		}
	
	}

}

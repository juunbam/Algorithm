package JobsAcademy.tree;
import java.util.ArrayList;
import java.util.Scanner;

class treeNode{
	String master;
	String left;
	String right;
	public treeNode(String master, String left, String right) {
		super();
		this.master = master;
		this.left = left;
		this.right = right;
	}
	public String getMaster() {
		return master;
	}
	public void setMaster(String master) {
		this.master = master;
	}
	public String getLeft() {
		return left;
	}
	public void setLeft(String left) {
		this.left = left;
	}
	public String getRight() {
		return right;
	}
	public void setRight(String right) {
		this.right = right;
	}
}
public class Tree {
	public static void preOrder(ArrayList<treeNode> T, int i) {
		System.out.print(T.get(i).getMaster()+" ");
		if(T.get(i).getLeft().compareTo("-1") != 0) {
			preOrder(T, indexOfmaster(T, T.get(i).getLeft()));
		}
		if(T.get(i).getRight().compareTo("-1") != 0) {
			preOrder(T, indexOfmaster(T, T.get(i).getRight()));
		}
	}
	public static void inOrder(ArrayList<treeNode> T, int i) {
		if(T.get(i).getLeft().compareTo("-1") != 0) {
			inOrder(T, indexOfmaster(T, T.get(i).getLeft()));
		}
		System.out.print(T.get(i).getMaster()+" ");
		if(T.get(i).getRight().compareTo("-1") != 0) {
			inOrder(T, indexOfmaster(T, T.get(i).getRight()));
		}
	}
	public static void postOrder(ArrayList<treeNode> T, int i) {
		if(T.get(i).getLeft().compareTo("-1") != 0) {
			postOrder(T, indexOfmaster(T, T.get(i).getLeft()));
		}
		if(T.get(i).getRight().compareTo("-1") != 0) {
			postOrder(T, indexOfmaster(T, T.get(i).getRight()));
		}
		System.out.print(T.get(i).getMaster()+" ");
	}
	public static int indexOfmaster(ArrayList<treeNode> T, String A) {
		for(int i=0;i<T.size();i++) {
			if(A.compareTo(T.get(i).getMaster()) == 0) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<treeNode> T = new ArrayList<treeNode>();
		int n = sc.nextInt();
		
		String[][] a = new String[n][3];
		
		for(int i=0;i<n;i++) {
			T.add(new treeNode(sc.next(), sc.next(), sc.next()));
		}
		
		preOrder(T, 0);
		System.out.println();
		inOrder(T, 0);
		System.out.println();
		postOrder(T, 0);
		System.out.println();
		
	}
}

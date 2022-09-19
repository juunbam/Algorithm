package ds.binarysearch;

public class Solution1 {
	public static int binarySearch(int f, int l, int t, int[] b) {
		int m = (f+l)/2;
		if(f==l || b[m] == t) {
			return m;
		}
		else if(b[m] < t) {
			return binarySearch(m+1, l, t, b);
		}
		else {
			return binarySearch(f, m, t, b);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] budgets = {100, 110, 100, 120};
//		int M = 485;
//		int total=0;
//
//		Arrays.sort(budgets);
//		int index = 0;
//		int n = budgets.length;
//		for(int i=0;i<n;i++) {
//			total+=budgets[i];
//			M -= budgets[i];
//			System.out.println(i+" "+total+" "+M);
//			if(i!= n-1 && M/(budgets.length-i-1) < budgets[i]) {
//				M+=budgets[i];
//				index = i;
//				break;
//			}
//		}
//
//		int answer = 0;
//		if(index == 0)
//			answer = budgets[budgets.length-1];
//		else
//			answer = M/(budgets.length-index);
//
//		System.out.println(answer);
	    String t = "asdfasdfasdfasfd dafsasd\n asdfasdfa  fa [Y/N]:";
	    StringBuilder builder = new StringBuilder();
	    builder.append("adsfasdfadfadsfadsfadsfa\n");
	    builder.append("adsfasdfadfadsfadsfadsfa\n");
	    builder.append("adsfasdfadfadsfadsfadsfa\n");
	    builder.append(t);
	    builder.append("adsfasdfadfad   sfadsfadsfa");
	    String tail = builder.substring(builder.length() - 20).trim();
	    System.out.println(tail);
		System.out.println(tail.endsWith("]:"));

		System.out.println("\u001b[1D");

	}

}

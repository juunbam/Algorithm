package ds.dynamicprogramming;

public class Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		int answer = 0;
		triangle[1][0] += triangle[0][0];
		triangle[1][1] += triangle[0][0];
		for(int i=2;i<triangle.length;i++) {
			for(int j=0;j<triangle[i].length;j++) {
				if(j == 0) {
					triangle[i][j] += triangle[i-1][j];
				}
				else if(j == triangle[i].length-1){
					triangle[i][j] += triangle[i-1][j-1];
				}
				else {
					triangle[i][j] = (triangle[i-1][j-1] + triangle[i][j] > triangle[i-1][j] + triangle[i][j]?triangle[i-1][j-1] + triangle[i][j]:triangle[i-1][j] + triangle[i][j]);
				}
				
				if(i == triangle.length - 1 && triangle[i][j] > answer) 
					answer = triangle[i][j];
			}
		}
		
		for(int i=0;i<triangle.length;i++) {
			for(int j=0;j<triangle[i].length;j++) {
				System.out.print(triangle[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(answer);
	}

}

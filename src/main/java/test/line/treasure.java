package test.line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class treasure {
	public static String[][] map;
	public static char[][] check;
	public static boolean[][] flag;
	public static void findTreasure(int x, int y, char previous) {
		String current = map[x][y];

		int value = Integer.parseInt(current.substring(1, 2));
		char next = 0;
		switch(previous){
			case 'F':
				switch(current.charAt(0)) {
					case 'F':
						next = 'F';
						break;
					case 'L':
						next = 'L';
						break;
					case 'R':
						next = 'R';
						break;
					case 'B':
						next = 'B';
						break;
				}
				break;
			case 'L':
				switch(current.charAt(0)) {
					case 'F':
						next = 'L';
						break;
					case 'L':
						next = 'B';
						break;
					case 'R':
						next = 'F';
						break;
					case 'B':
						next = 'R';
						break;
				}
				break;
			case 'R':
				switch(current.charAt(0)) {
					case 'F':
						next = 'R';
						break;
					case 'L':
						next = 'F';
						break;
					case 'R':
						next = 'B';
						break;
					case 'B':
						next = 'L';
						break;
				}
				break;
			case 'B':
				switch(current.charAt(0)) {
				case 'F':
					next = 'B';
					break;
				case 'L':
					next = 'R';
					break;
				case 'R':
					next = 'L';
					break;
				case 'B':
					next = 'F';
					break;
				}
				break;
		}
		if(next == check[x][y] && flag[x][y]) {
			System.out.println(y+" "+x);
			return;
		}
		check[x][y] = next;
		flag[x][y] = true;

		switch(next) {
		case 'F':
			findTreasure(x+value, y, next);
			break;
		case 'R':
			findTreasure(x, y-value, next);
			break;
		case 'L':
			findTreasure(x, y+value, next);
			break;
		case 'B':
			findTreasure(x-value, y, next);
			break;
		}
	}
    public static void main(String[] args) throws IOException {
//        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            final int n = Integer.parseInt(br.readLine());
//            map = new String[n][n];
//            flag = new boolean[n][n];
//            check = new char[n][n];
//            for (int i = 0; i < n; i++) {
//                map[i] = br.readLine().split(" ");
//                // @todo Write your code here.
//            }
//
//            findTreasure(0,0,map[0][0].charAt(0));
//            // @todo Write your code here.
//        }
    }
}
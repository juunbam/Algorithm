package test.samsung.practice;
import java.util.Scanner;

public class Runway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		
		int[][] map = new int[N][N];
		boolean[] rw;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int Answer = 0;
		for(int i=0;i<N;i++) {
			rw = new boolean[N];
			int f = map[i][0];
			boolean check = true;
			for(int j=1;j<N;j++) {
				if(f == map[i][j]) {
					continue;
				}
				if(f != map[i][j]) {
					if(map[i][j] == (f+1)) {
						if(j-L >= 0) {
							boolean flg = true;
							for(int k=j-1;k>=j-L;k--) {
								if(map[i][k] != f || rw[k]) {
									flg = false;
									break;
								}
								else {
									rw[k] = true;
								}
							}
							if(flg) {
								f = map[i][j];
							}
							else {
								check=false;
								break;
							}
						}
						else {
							check = false;
							break;
						}
					}
					else if(map[i][j] == (f-1)) {
						if(j+L-1 < N) {
							f = map[i][j];
							boolean flg = true;
							for(int k=j;k<j+L;k++) {
								if(map[i][k] != f || rw[k]) {
									flg = false;
									break;
								}
								else {
									rw[k] = true;
								}
							}
							if(flg) {
								j=j+L-1;
							}
							else {
								check = false;
								break;
							}
						}
						else {
							check = false;
							break;
						}
					}
					else { 
						check = false;
						break;
					}
				}
			}
			if(check) {
				Answer++;
			}
		}
		for(int i=0;i<N;i++) {
			rw = new boolean[N];
			int f = map[0][i];
			boolean check = true;
			for(int j=1;j<N;j++) {
				if(f == map[j][i]) {
					continue;
				}
				if(f != map[j][i]) {
					if(map[j][i] == (f+1)) {
						if(j-L >= 0) {
							boolean flg = true;
							for(int k=j-1;k>=j-L;k--) {
								if(map[k][i] != f || rw[k]) {
									flg = false;
									break;
								}
								else {
									rw[k] = true;
								}
							}
							if(flg) {
								f = map[j][i];
							}
							else {
								check=false;
								break;
							}
						}
						else {
							check = false;
							break;
						}
					}
					else if(map[j][i] == (f-1)) {
						if(j+L-1 < N) {
							f = map[j][i];
							boolean flg = true;
							for(int k=j;k<j+L;k++) {
								if(map[k][i] != f || rw[k]) {
									flg = false;
									break;
								}
								else {
									rw[k] = true;
								}
							}
							if(flg) {
								j=j+L-1;
							}
							else {
								check = false;
								break;
							}
						}
						else {
							check = false;
							break;
						}
					}
					else { 
						check = false;
						break;
					}
				}
			}
			if(check) {
				Answer++;
			}
		}
		System.out.println(Answer);
	}

}

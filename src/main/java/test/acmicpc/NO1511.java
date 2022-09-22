package test.acmicpc;
//link: https://www.acmicpc.net/problem/1511


import java.util.Scanner;

public class NO1511 {

    public static void main(String[] args){
        int[] out = new int[51];
        int flag = 0;

        Scanner sc = new Scanner(System.in);
        int[] N = new int[10];

        for(int i = 0; i < N.length; i++){
            N[i] = sc.nextInt();
        }

        int cnt = 0;
        for(int i=0;i<10;i++) {
            cnt += N[i];
        }

        int max = cnt;

        if(max == N[0]) {
            System.out.println("0");
            return ;
        }
        for(int i=0;i<10;i++){
            if(N[i]>(max-N[i])){
                if(i!=0) {
                    N[i] = max-N[i]+1;
                } else {
                    N[i] = max-N[i];
                }
            }
        }

        cnt = 0;
        for(int i=0;i<10;i++){
            cnt += N[i];
        }
        max = cnt;

        for(int i=0;i<max;i++){
            if((max-i)%2==1){
                for(int j=0;j<10;j++){
                    if(N[j]>(max-i)-N[j]) {
                        out[i] = j;
                        N[j]--;
                        i++;
                        flag=j;
                    }
                }
            }

            for(int j=9;j>=0;j--){
                if(N[j] != 0 && flag!=j) {
                    out[i] = j;
                    N[j]--;
                    flag=j;
                    break;
                }
            }
        }

        for(int i=0;i<max;i++) {
            System.out.print(out[i]);
        }
        System.out.print("\n");
    }
}

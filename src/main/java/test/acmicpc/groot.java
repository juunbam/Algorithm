package test.acmicpc;

import java.util.Scanner;

public class groot {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int R = sc.nextInt();

        System.out.println(L+" "+R);
        int len = L;
        int total = 0;
        int n = 1;
        while(len>5) {
            total = total+(2*n*(len*(R/100)));
            n = n*2;
            len = len*(R/100);
            System.out.println(n+" "+len+" "+total);
        }
        System.out.println(total);
    }

}

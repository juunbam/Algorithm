package test.acmicpc;

import java.util.Scanner;

public class NO6417 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int N = sc.nextInt();
            if (N > 0) {
                int k = 0;
                boolean check = false;
                for (int i = 10; i >= 2; i--) {
                    int a = N;
                    int count = 0;

                    for (int j = 1; j <= i; j++) {
                        if (a % i == 1) {
                            a = a - (a / i) - 1;
                            count++;
                        }
                    }

                    if (count == i && a % i == 0) {
                        k = i;
                        check = true;
                        break;
                    }
                }

                if (check) {
                    System.out.println(N + " coconuts, " + k + " people and 1 monkey");
                } else {
                    System.out.println(N + " coconuts, no solution");
                }
            } else {
                break;
            }
        }
    }
}

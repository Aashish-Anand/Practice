package CodeForces;

import java.util.Scanner;

/*
https://codeforces.com/problemset/problem/390/A
 */
public class InnaAlarmClock {
    public static void main(String[] args) {
        new InnaAlarmClock().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int x[] = new int[101];
        int y[] = new int[101];

        while(n-->0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            x[a] = 1;
            y[b] = 1;
        }
        long sumx = 0;
        long sumy = 0;
        for(int i = 0;i<101;i++) {
            sumx += x[i];
            sumy += y[i];
        }
        System.out.print(Math.min(sumx, sumy));
    }

}

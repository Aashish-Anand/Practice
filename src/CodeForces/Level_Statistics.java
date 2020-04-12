package CodeForces;

import java.util.Scanner;

/**
 * https://codeforces.com/problemset/problem/1334/A
 */
public class Level_Statistics {

    public static void main(String[] args) {
        new Level_Statistics().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int plays[] = new int[n];
            int clear[] = new int[n];

            for (int i = 0; i < n; i++) {
                plays[i] = sc.nextInt();
                clear[i] = sc.nextInt();
            }

            int initialPlays = plays[0];
            int intialClear = clear[0];
            boolean flag = true;
            if (intialClear > initialPlays) {
                flag = false;
            } else {
                for (int i = 1; i < n; i++) {
                    if (plays[i] < initialPlays || clear[i] < intialClear || clear[i] > plays[i]) {
                        flag = false;
                        break;
                    }else if(initialPlays == plays[i] && clear[i]> intialClear) {
                        flag = false;
                         break;
                    }
                    else {
                        if(clear[i] - intialClear > plays[i] - initialPlays){
                            flag = false;
                            break;
                        }
                        intialClear = clear[i];
                        initialPlays = plays[i];
                    }
                }
            }

            System.out.println(flag? "YES" : "NO");
        }
    }
}

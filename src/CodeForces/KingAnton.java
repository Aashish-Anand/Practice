package CodeForces;

import java.util.Arrays;
import java.util.Scanner;

public class KingAnton {
    public static void main(String[] args) {
        new KingAnton().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-->0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];

            for(int i = 0;i<n;i++) {
                a[i] = sc.nextInt();
            }
            for(int i = 0;i<n;i++) {
                b[i] = sc.nextInt();
            }

            if(a[0]!= b[0]) {
                System.out.println("NO");
                continue;
            }

            boolean check[] = new boolean[n];
            Arrays.fill(check, false);
            check[0] = true;

            for(int i = 0;i<n;i++) {
                if(a[i] == b[i]){
                    check[i] = true;
                }
            }
            for(int i = 0;i<n-1;i++) {
                for(int j = i+1;j<n;j++){

                    if(!check[j] && a[i] != 0) {
                        if (b[j] < a[j] && a[i] == -1) {
                            check[j] = true;
                        } else if (b[j] > a[j] && a[i] == 1) {
                            check[j] = true;
                        }
                    }
                }
            }

            boolean flag = true;
            for(int i = 0;i<n;i++) {
                if(!check[i]){
                    System.out.println("NO");
                    flag = false;
                }
            }
            if(flag){
                System.out.println("YES");
            }

        }
    }
}

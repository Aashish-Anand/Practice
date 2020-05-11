package gfg_interview_prep;

import java.util.Scanner;

public class StockBuySell {

    public static void main(String[] args) {
        new StockBuySell().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();

            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int i = 0;
            while (i < n) {

                if (i == 0 && arr[i] < arr[i + 1]) {
                    System.out.print("(" + i + " ");
                } else if (i > 0 && i < n-1 && arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    System.out.print("(" + i + " ");
                } else if (i > 0 && i < n-1 && arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    System.out.print(i + ") ");
                } else if (i == n - 1 && arr[i] > arr[i - 1]) {
                    System.out.print(i + ") ");
                }
                i++;
            }
            System.out.println();
        }
    }
}

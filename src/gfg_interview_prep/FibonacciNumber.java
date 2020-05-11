package gfg_interview_prep;

import java.util.Scanner;

/**
 * Find the last 2 digits of nth Fibonacci number
 *
 *
 * There is a fact that after 300th fibonacci number
 * the last two digits start repeating
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        new FibonacciNumber().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        n = n%300;

        System.out.println(findFiboNumber(n));
    }

    private int findFiboNumber(int n) {
        int arr[] = new int[n+1];


        arr[0]= 0;
        arr[1] = 1;

        for(int i = 2;i<=n;i++) {
            arr[i] = (arr[i-1]+arr[i-2])%100;
        }

        return arr[n]%100;
    }

}

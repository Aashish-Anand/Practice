package gfg_interview_prep;

import java.util.Scanner;

public class CountSubarrayWithfibonacciSum {
    public static void main(String[] args) {
        new CountSubarrayWithfibonacciSum().run();
    }

    private void run() {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];
        for(int i = 0;i<n;i++) {
            arr[i] = sc.nextInt();
        }

        findFibonacciSumSubarray(arr,n);
    }

    private void findFibonacciSumSubarray(int arr[],int n) {

        int count = 0;
        for(int i = 0;i<n;i++) {
            int sum = 0;
            for(int j = i;j<n;j++) {
                sum += arr[j];

                if(checkFibonacci(sum)) {
                    count++;
                }

            }
        }
        System.out.println(count);
    }
    private boolean checkFibonacci(int sum) {
        return perfectSquare(5*sum*sum + 4) || perfectSquare(5*sum*sum - 4);
    }

    private boolean perfectSquare(int num) {
        int sq = (int) Math.sqrt(num);

        return sq*sq == num;
    }
}

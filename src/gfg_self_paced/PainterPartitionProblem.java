package gfg_self_paced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PainterPartitionProblem {
    public static void main(String[] args) throws IOException {
        new PainterPartitionProblem().run();
    }

    private void run() throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for(int i = 0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int painterWeHave = sc.nextInt();

        if(painterWeHave > n){
            System.out.println("Not possible");
            return;
        }
        int sum = findSum(arr, n);
        int max = findMax(arr, n);

        int answer = 0;
        while(max <= sum) {
            int mid = max + (sum-max)/2;

            if(paintersRequired(arr, mid) <= painterWeHave) {
                sum = mid-1;
                answer = mid;
            }
            else{
                max = mid +1;
            }
        }
        System.out.println(answer);
    }

    private int findSum(int arr[] , int n) {

        int sum = 0;
        for(int i = 0;i<n;i++) {
            sum += arr[i];
        }
        return sum;
    }

    private int findMax(int arr[], int n) {
        int max = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    private int paintersRequired(int arr[], int sum) {
        int count = 0;
        int tempsum = 0;
        for(int i = 0;i<arr.length;i++) {
            tempsum+= arr[i];
            if(tempsum > sum) {
                count++;
                tempsum = arr[i];
            }
        }
        count++;
        return count;
    }
}

package CodeForces;

import java.util.Scanner;

/*
https://codeforces.com/problemset/problem/1145/A
 */
public class ThanosSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];
        for(int i = 0;i<n;i++) {
            arr[i] = sc.nextInt();
        }

        if(n == 1) {
            System.out.println(1);
        }
        else{
            boolean flag = true;
            for(int i = 0;i<n-1;i++) {
                if(arr[i]>arr[i+1]) {
                    flag = false;
                }
            }
            if(!flag) {
                System.out.println(sortItOut(arr, 0, n-1));
            }
            else{
                System.out.println(n);
            }

        }
    }
    private static int sortItOut(int arr[], int i, int j){

        if(i == j){
            return 1;
        }
        int mid = (i+j)/2;
        int max1 = sortItOut(arr,i,mid);
        int max2 = sortItOut(arr, mid+1,j);
        if(arr[mid]<=arr[mid+1] && (mid+1 - i == max1) && (j - mid ==max2)) {
                    return max1 + max2;
        }
        else{
            return Math.max(max1, max2);
        }
    }
}

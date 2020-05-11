package gfg_interview_prep;

import java.util.Scanner;

public class pairSortedArray {
    public static void main(String[] args) {
        new pairSortedArray().run1();
    }

    private void run1() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            int arr[] =  new int[n];

            for(int i = 0;i<n;i++) {
                arr[i] = sc.nextInt();
            }

            int sum = sc.nextInt();

            boolean flag = false;

            int i = 0;
            while(i<n-1) {

                int pos = find(arr, i, n-1, n, sum);

                if(pos != -1) {
                    flag = true;
                    System.out.println(arr[i]+" " +arr[pos] +" "+sum);
                }
                i++;
            }

            if(!flag ) {
                System.out.println(-1);
            }

        }
    }
    private int find(int arr[], int i, int j , int n, int sum) {

        while(i<j) {
            if(arr[i]+arr[j] == sum) {
                return j;
            }
            else if(arr[i]+arr[j]<sum){
                return -1;
            }
            else {
                j--;
            }
        }
        return -1;
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            int arr[] =  new int[n];

            for(int i = 0;i<n;i++) {
                arr[i] = sc.nextInt();
            }

            int sum = sc.nextInt();

            boolean flag = false;

            for(int i = 0;i<n-1;i++) {
                int remainingNumber = sum - arr[i];
                if(remainingNumber < 0){
                    continue;
                }
                else{
                    int pos = findRemainingNumber(arr, i+1, n-1, remainingNumber);

                    if(pos != -1) {
                        flag = true;
                        System.out.println(arr[i]+" " +arr[pos] +" "+sum);
                       // continue;
                    }
                }
            }
            if(!flag ){
                System.out.println(-1);
            }

        }
    }

    private int findRemainingNumber(int arr[], int l, int r, int remainingNumber) {

        while(l<=r) {
            int mid = l + (r-l)/2;

            if(arr[mid] == remainingNumber) {
                return mid;
            }
            else if(arr[mid] > remainingNumber){
                r = mid -1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;

    }
}

package chefTeCode;

import java.util.Arrays;
import java.util.Scanner;

public class ECAPR206 {
    public static void main(String[] args) {
        new ECAPR206().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int arr[] = new int[n];

            for (int i = 0;i<n;i++) {
                arr[i] = sc.nextInt();
            }

//            int sum[] = new int[n];
//            int i = 0;
//            while(i<n) {
//                int j = i;
//                int count=0;
//                while(true) {
//                    sum[i] += arr[j++];
//                    count++;
//                    if(j == n) {
//                        j = 0;
//                    }
//                    if(count==k){
//                        break;
//                    }
//
//                }
//                i++;
//            }
//            Arrays.sort(sum);
//            System.out.println(sum[n-1]);
////            for(i = 0;i<n;i++) {
////                System.out.println(sum[i]);
////            }

            //method 2
            //sliding window
            int sum = 0;
            for(int i = 0;i<k;i++) {
                sum+=arr[i];
            }
            int maxsum= sum;
            int firstindex = 0;
            int lastindex = k-1;

            while(firstindex!= n-1) {
                sum -= arr[firstindex];
                firstindex++;
                lastindex++;
                if(lastindex==n){
                    lastindex = 0;
                }
                sum+=arr[lastindex];

                if(maxsum<sum) {
                    maxsum = sum;
                }
            }
            System.out.println(maxsum);
        }
    }
}

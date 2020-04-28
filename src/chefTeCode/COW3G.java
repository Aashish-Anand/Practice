package chefTeCode;

import java.util.Arrays;
import java.util.Scanner;

public class COW3G {

    public static void main(String[] args) {
        new COW3G().run();
    }
    private void run() {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long arr[] = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        //This is my solution now it is correct but unable to solve it on time
        // because i was using int but during calculation it reaches beyond the Int limit
        // so that why it is giving wrong answer.
        ///  Now it is correct now
        long largest = Integer.MIN_VALUE;
        if(n == 1){
            largest = arr[0];
        }
        else{
            for (int i = n - 1; i >= 0; i--) {
                long num = arr[i] - 1;

                while (num >= 0) {
                    if (Arrays.binarySearch(arr, num) >= 0 && gcd(arr[i], num) == 1) {
                        if (largest < arr[i] * num) {
                            largest = arr[i] * num;
                        }
                        break;
                    }
                    num--;
                }

            }
        }
        System.out.println(largest);

//        Correct Solution

//        long maxLcm = 0;
//        for(int i = n-1;i>=0;i--) {
//            if(arr[i]*arr[i]<=maxLcm) {
//                break;
//            }
//
//            for(int j = i-1;j>=0;j--) {
//                if(arr[i]*arr[j]<=maxLcm){
//                    break;
//                }
//
//                long lcm = (arr[i]*arr[j])/gcd(arr[i], arr[j]);
//
//                maxLcm = Long.max(lcm, maxLcm);
//            }
//        }
//
//        System.out.println(maxLcm);

    }
    private long gcd(long a , long b) {
        if(b == 0) {
            return a;
        }
        else{
            return gcd(b, a%b);
        }
    }


}

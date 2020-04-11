package chefTeCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CARSELL {
    public static void main(String[] args) {
        new CARSELL().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            Integer arr[]= new Integer[n];
            for(int i = 0;i<n;i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr, Collections.reverseOrder());

            int sum = 0;
            for(int i = 0;i<n;i++) {
                if(arr[i] - i > 0) {
                    sum += (arr[i] - i);
                    sum %= 1000000007;
                }
                else{
                    break;
                }

            }
            System.out.println(sum);
        }

    }
}

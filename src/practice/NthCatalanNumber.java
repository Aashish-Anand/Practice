package practice;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Find the nth catalan number
 */
public class NthCatalanNumber {
    public static void main(String[] args) {
        new NthCatalanNumber().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        BigInteger arr[] = new BigInteger[n+2];
        Arrays.fill(arr,BigInteger.ZERO);
        arr[0] = BigInteger.ONE;
        arr[1] = BigInteger.ONE;
        for(int i = 2;i<=n;i++) {

            for(int j = 0;j<i;j++) {
                arr[i] = arr[i].add (arr[j].multiply(arr[i-j-1]));
            }
        }
//        for(int i = 0;i<=n;i++) {
//            System.out.print(arr[i]+ " ");
//        }
        System.out.println(arr[n]);

    }
}

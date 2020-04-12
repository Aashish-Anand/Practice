package CodeForces;

import java.util.Arrays;
import java.util.Scanner;

/*
https://codeforces.com/contest/1339/problem/B
 */
public class Sorted_Adjacent_Differences {
    public static void main(String[] args) {
        new Sorted_Adjacent_Differences().run();
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
            Arrays.sort(arr);

            int newArr[] = new int[n];
            int i = 0;
            int j = n - 1;
            int index = n - 1;
            while (i < j) {
                newArr[index--] = arr[i++];
                newArr[index--] = arr[j--];
            }
            if(index == 0) {
                newArr[index] = arr[i];
            }

            for (i = 0; i < n; i++) {
                System.out.print(newArr[i] + " ");
            }
        }
    }
}

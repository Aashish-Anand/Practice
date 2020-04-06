package skillenza;

import java.util.Arrays;
import java.util.Scanner;

public class AryaAndArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int arr[] = new int[1001];
            Arrays.fill(arr, 0);

            long firstArraySum = 0;
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                firstArraySum += num;
                arr[num] += 1;
            }

            long secondArraySum = 0;
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                secondArraySum += num;
                arr[num] -= 1;
            }


            int diffCount = 0;
            for (int i = 0; i < 1001; i++) {
                if (arr[i] != 0) {
                    diffCount+=Math.abs(arr[i]);
                }
            }
//System.out.println(diffCount);
            int biggerCount = firstArraySum > secondArraySum ? 2 : 1;
            long diff = Math.abs(firstArraySum - secondArraySum);
            if (diffCount == 0) {
                System.out.println("Yes");
            } else if (diffCount == 2) {
                System.out.println(diff + " " + biggerCount);
            } else {
                System.out.println("No");
            }

        }
    }
}

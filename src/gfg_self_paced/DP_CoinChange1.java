package gfg_self_paced;

import java.util.Arrays;

/*
Problem : https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 */
public class DP_CoinChange1 {

    public static void main(String[] args) {
        new DP_CoinChange1().run();
    }

    private void run() {
        int sumRequired = 10;
        int[] coinArray = {2, 5, 3, 6};

        System.out.println(findMinimumNumberOfCoinsRequired(sumRequired, coinArray));
    }

    private int findMinimumNumberOfCoinsRequired(int sumRequired, int[] coinArray) {

        int[] sumArray = new int[sumRequired + 1];
        Arrays.fill(sumArray, Integer.MAX_VALUE);

        sumArray[0] = 0;   // for required sum = 0 we need zero coins

        for (int coin : coinArray) {
            for (int i = 1; i <= sumRequired; i++) {
                /*
                What we have check here is
                Either consider the current value
                or just consider current value and find for the remaining sum
                i.e if req sum = 2;
                then if we are currently processing coin with value 2
                then we find Minimum of (sumArray[2], 1+ sumArray[2-2]); therefore (max, 1) so
                answer is 1.
                 */
                if (i >= coin) {
                    int var2 = Integer.MAX_VALUE;
                    if (sumArray[i - coin] != Integer.MAX_VALUE) {
                        var2 = 1 + sumArray[i - coin];
                    }
                    sumArray[i] = Math.min(sumArray[i], var2);
                }
            }
        }
        return sumArray[sumRequired];
    }
}

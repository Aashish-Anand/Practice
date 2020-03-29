package gfg_self_paced;

public class DP_CoinChange2 {

    public static void main(String[] args) {
        new DP_CoinChange2().run();
    }

    private void run() {
        int sumRequired = 10;
        int[] coinArray = {2, 5, 3, 6};

        System.out.println(findNumberOfWays(sumRequired, coinArray));
    }

    private int findNumberOfWays(int sumRequired, int[] coinArray) {
        int n = coinArray.length;

        int sumArray[] = new int[sumRequired + 1];

        sumArray[0] = 1;

        for (int coin : coinArray) {
            for (int i = 1; i < sumRequired + 1; i++) {

                if (i >= coin) {
                    sumArray[i] += sumArray[i - coin];
                }
            }
        }
        return sumArray[sumRequired];
    }
}
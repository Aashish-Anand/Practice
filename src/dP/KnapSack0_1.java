package dP;

public class KnapSack0_1 {
    public static void main(String[] args) {
        new KnapSack0_1().run();
    }

    private void run() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = solveKnapsack(profits, weights, 7);
        System.out.println(maxProfit);
    }

    private int solveKnapsack(int profits[], int weights[], int capacity) {

        if(profits.length!=weights.length){
            return 0;
        }

        int n = profits.length;
        int dp[][] = new int[n][capacity+1];

        for(int i = 0;i<n;i++) {
            dp[i][0] = 0;
        }

        for(int i = 0;i<=capacity;i++) {
            if(weights[0]<=i) {
                dp[0][i] = profits[0];
            }
        }

        for(int i= 1;i<n;i++) {
            for(int j = 1;j<=capacity;j++) {  // here is the capacity
                int profit1; // profit by excluding current element
                int profit2 = 0; // profit by including current element
                profit1 = dp[i-1][j];
                if(weights[i]<=j) {
                    profit2 = profits[i]+dp[i-1][j-weights[i]];
                }
                dp[i][j] = Math.max(profit1, profit2);
            }
        }

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<=capacity;j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[n-1][capacity];
    }
}

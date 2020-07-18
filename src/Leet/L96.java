package Leet;

public class L96 {
    public static void main(String[] args) {
        new L96().run();
    }

    private void run() {
        int n = 6;
        System.out.println(numTrees(n));
    }

    private int numTrees(int n) {

        /*
        It's nothing but a catalyn number problem
         */
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2;i<=n;i++) {

            int sum = 0;
            for(int j = 0;j<i;j++) {
                sum+= (dp[j]*dp[i-j-1]);
            }
            dp[i] = sum;

        }
        return dp[n];
    }
}

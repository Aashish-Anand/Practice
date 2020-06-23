package Leet;

public class L221 {
    public static void main(String[] args) {
        new L221().run();
    }

    private void run() {
//        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1',
//                '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix = {};
        System.out.println(maximalSquare(matrix));
    }

    private int maximalSquare(char[][] matrix) {

        int n = matrix.length;
        if(n == 0){
            return 0;
        }
        int m = matrix[0].length;

        int dp[][] = new int[n+1][m+1];

        for(int i = 0;i<n;i++) {
            dp[i][0] = 0;
        }
        for(int i = 0;i<m;i++) {
            dp[0][i] = 0;
        }
        int max = 0;
        for(int i = 1;i<=n;i++) {
            for(int j = 1;j<=m;j++) {
                if(matrix[i-1][j-1]=='1') {
                    dp[i][j] = 1+ Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                    if(dp[i][j]>max) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return (int)Math.pow(max,2);
    }
}

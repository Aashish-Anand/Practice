package Subsequence_And_Subarray;


public class LongestSubsquenceOfOneStringWhichIsSubstringOfAnotherString {
    public static void main(String[] args) {
        new LongestSubsquenceOfOneStringWhichIsSubstringOfAnotherString().run();
    }

    private void run() {
        String str1 = "ABCD";
        String str2 = "BACDBDCD";

        int n = str1.length();
        int m = str2.length();

        System.out.println(findLen(str1.toCharArray(), str2.toCharArray(), n,m));
    }
    private int findLen(char a[], char b[] , int n , int m) {

        int dp[][] = new int[n+1][m+1];

        for(int i = 0;i<=n;i++) {
            dp[i][0] = 0;
        }
        for(int i = 0;i<=m;i++) {
            dp[0][i] = 0;
        }

        for(int i =1;i<=n;i++) {
            for(int j = 1;j<=m;j++) {
                if(a[i-1] == b[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for(int i = 0;i<=n;i++) {
            for(int j = 0;j<=m;j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }

        int max = 0;
        for(int i = 0;i<=m;i++) {
            max = Math.max(max, dp[n][i]);
        }

        return max;
    }
}

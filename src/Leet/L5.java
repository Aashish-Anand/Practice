package Leet;

public class L5 {
    public static void main(String[] args) {
        new L5().run();
    }

    private void run() {
        String str = "abada";
        String reverseString = (new StringBuilder(str)).reverse().toString();

        System.out.println(findLongestPalindromicSubstring(str, reverseString));
    }

    private String findLongestPalindromicSubstring(String s, String revers) {
        int n = s.length();
        int dp[][] = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            int j = i;
                if (s.charAt(i - 1) == revers.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
        }
        for (int i = 0;i<n+1;i++){
            for(int j = 0;j<n+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        int i = n;
        int j = n;
        String ans = "";
        while (i > 0 && j >0) {
            if (s.charAt(i - 1) == revers.charAt(j - 1)) {
                ans += s.charAt(i - 1);
                i--;
                j--;
            }
            else{
                i--;
            }
        }
        return ans;

    }

}

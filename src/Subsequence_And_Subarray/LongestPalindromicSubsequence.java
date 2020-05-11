package Subsequence_And_Subarray;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        new LongestPalindromicSubsequence().run();
    }

    private void run() {
        String x = "ABBDCACB";
        String y = new StringBuilder(x).reverse().toString();

        int len1 = x.length();
        int len2 = y.length();

        int[][] mat = new int[len1+1][len2+1];

        System.out.println(lengthOfSubSequence(x,y,len1,mat));
        System.out.println(findSubsequenceItself(x,y,len1,len2, mat));
    }

    private int lengthOfSubSequence(String x, String y, int len1, int mat[][]) {

        for(int i = 1;i<=len1;i++) {
            for(int j = 1;j<=len1;j++) {
                if(x.charAt(i-1)==y.charAt(j-1)) {
                    mat[i][j] = mat[i-1][j-1]+1;
                }
                else{
                    mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
                }
            }
        }

        return mat[len1][len1];
    }

    private String findSubsequenceItself(String x, String y, int len1, int len2, int mat[][]) {

        if(len1==0 || len2==0) {
            return "";
        }

        if(x.charAt(len1-1)==y.charAt(len2-1)) {
            return findSubsequenceItself(x,y,len1-1, len2-1, mat) + x.charAt(len1-1);
        }
        else if(mat[len1-1][len2] > mat[len1][len2-1]) {
            return findSubsequenceItself(x,y, len1 -1, len2,mat);
        }

        return findSubsequenceItself(x,y,len1, len2-1, mat);
    }
}

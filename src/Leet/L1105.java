package Leet;

public class L1105 {
    public static void main(String[] args) {
        new L1105().run();
    }

    private void run() {
        int books[][] = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int shelf_width = 4;

        System.out.println(minHeightSelves(books, shelf_width));
    }
    private int minHeightSelves(int books[][], int shelf_width) {
        int dp[] = new int[books.length+1];
        dp[0] = 0;

        for(int i = 1;i<=books.length;i++) {
            int width = books[i-1][0];
            int height = books[i-1][1];
            dp[i] = dp[i-1]+height;

            for(int j = i-1; j>0 && width+books[j-1][0]<=shelf_width;j--) {
                width+= books[j-1][0];
                height = Math.max(height,books[j-1][1]);
                dp[i] = Math.min(dp[i], dp[j-1]+height);
            }
        }
        return dp[books.length];

    }
}
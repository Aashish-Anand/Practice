package test;

/*
Amazon test Question
Modified number of Island Problem

Question 1 :
    Amazon wants to open the store in an area .
    Area is given in matrix form
    where each cell is a block if adjacent blocks have one then it will considered as
    1 store. Diagonal blocks are not considered in block.

    Eg 1 : 1 1 0 0
           0 0 1 0
           1 0 0 1
           1 1 1 1

    answer : 3 blocks i.e 2 1's in first row , 1 1's in second row, in 3rd and 4th row conbined form a block
             so thats the third block.

    Eg 2 :  1 0 0 0
            0 1 0 0
            0 0 1 0
            0 0 0 1

    Answer is 4 blocks
 */
public class Amazon1 {

    private static boolean isSafe(int[][] mat, int[][] visited, int i, int j) {
        return (i>=0 && i<mat.length && j>=0 && j<mat[0].length && mat[i][j]==1 && visited[i][j]==0);
    }
    private static void callStoreFinder(int[][] mat, int[][] visited, int i, int j) {
        int[] x = new int[]{-1, 0, 0, 1};
        int[] y = new int[]{0, -1, 1, 0};

        for (int k = 0; k < 4; k++) {
            int new_x = i + x[k];
            int new_y = j + y[k];
            if(isSafe(mat, visited, new_x, new_y)) {
                visited[new_x][new_y]=1;
                callStoreFinder(mat, visited ,new_x, new_y);
            }
        }
    }

    private static int findTheNumberOfAmazonStore(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int[][] visited = new int[row][col];

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((mat[i][j] == 1) && (visited[i][j] == 0)) {
                    visited[i][j] = 1;
                    callStoreFinder(mat, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}};

        int[][] mat1 = {{1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}};
        System.out.println(findTheNumberOfAmazonStore(mat));
        System.out.println(findTheNumberOfAmazonStore(mat1));
    }
}

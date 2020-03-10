package HackerRank;

/**
 * Problem Url : https://www.hackerrank.com/challenges/queens-attack-2/problem
 */
public class QueenAttack {

    private static boolean isSafe(long mat[][], int n, int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n && mat[x][y] != -1) {
            return true;
        }
        return false;
    }

    private static int fillHorizontal(int n, long mat[][], int x, int y) {

        int count = 0;
        //left
        for (int i = y + 1; i < mat[0].length; i++) {
            if (isSafe(mat, n, x, i)) {
                mat[x][i] = 2;
                count++;
            } else {
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (isSafe(mat, n, x, i)) {
                mat[x][i] = 2;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private static int fillVertical(int n, long mat[][], int x, int y) {

        int count = 0;
        //left
        for (int i = x + 1; i < mat.length; i++) {
            if (isSafe(mat, n, i, y)) {
                mat[i][y] = 2;
                count++;
            } else {
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            if (isSafe(mat, n, i, y)) {
                mat[i][y] = 2;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private static int fillMainDiagonal(int n, long mat[][], int x, int y) {

        int count = 0;

        //left - up
        int i = x-1;
        int j = y-1;
        while(i >= 0 && j>=0) {
            if(isSafe(mat,n,i,j)) {
                mat[i][j] = 2;
                count++;
            }
            else{
                break;
            }
            i--;
            j--;
        }

        //right down
        i = x+1;
        j = y+1;
        while(i <mat.length  && j<mat.length) {
            if(isSafe(mat,n,i,j)) {
                mat[i][j] = 2;
                count++;
            }
            else{
                break;
            }
            i++;
            j++;
        }

        //anti diagonal
        //right up
        i = x-1;
        j = y+1;
        while(i >=0 && j<mat.length) {
            if(isSafe(mat,n,i,j)) {
                mat[i][j] = 2;
                count++;
            }
            else{
                break;
            }
            i--;
            j++;
        }
        i = x+1;
        j = y-1;
        while(i <mat.length && j>=0) {
            if(isSafe(mat,n,i,j)) {
                mat[i][j] = 2;
                count++;
            }
            else{
                break;
            }
            i++;
            j--;
        }
        return count;
    }

    private static int findMoves(int n, int k, int queen_x, int queen_y, int obstacles[][]) {

        long mat[][] = new long[n][n];
        for (int i = 0; i < obstacles.length; i++) {
            if(isSafe(mat, n, obstacles[i][0] - 1,obstacles[i][1] - 1)) {
                mat[obstacles[i][0] - 1][obstacles[i][1] - 1] = -1;
            }
        }

        mat[queen_x - 1][queen_y - 1] = 1;

//        for (int i = 0; i < n; i++) {
//            System.out.println();
//            for (int j = 0; j < n; j++) {
//                System.out.print(mat[i][j] + " ");
//            }
//        }
        int count = fillHorizontal(n, mat, queen_x - 1, queen_y - 1)
                        + fillVertical(n, mat, queen_x - 1, queen_y - 1)
                            +fillMainDiagonal(n, mat, queen_x - 1, queen_y - 1);

//        for (int i = 0; i < n; i++) {
//            System.out.println();
//            for (int j = 0; j < n; j++) {
//                System.out.print(mat[i][j] + "   ");
//            }
//        }
        return count;
    }

    public static void main(String[] args) {
        int n = 1000;
        int k = 0;
        int queen_x = 5;
        int queen_y = 5;

        //int obstacles[][] = {{5, 5}, {4, 2}, {2, 3}};
        int obstacles[][] = {};

        System.out.println(findMoves(n, k, queen_x, queen_y, obstacles));

    }
}

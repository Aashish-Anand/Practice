package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NQueen {
    public static void main(String[] args) throws IOException {
        new NQueen().run();
    }

    private void run() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int queen[][] = new int[n][n];

        //Arrays.fill(queen,0);

        if(findNQueen(queen, n, 0)==false) {
            System.out.println("No answer");
            return;
        }

        printQueen(queen, n);
    }

    private boolean findNQueen(int queen[][], int n , int row) {
        if(row>=n){
            return true;
        }

            for(int j=0;j<n;j++) {

                if(isSafe(queen, row,j,n)) {
                    queen[row][j] = 1;

                    if (findNQueen(queen,n, row+1)) {
                        return true;
                    }

//                    printQueen(queen,n);
//                    System.out.println();
                    queen[row][j] = 0;
                }
        }
        return false;
    }

    private boolean isSafe(int queen[][], int row, int col, int n) {

        // check the vertical line
        for(int i = row-1;i>=0;i--) {
            if(queen[i][col]==1){
                return false;
            }
        }

        // upper left diagonal
        int i = row-1;
        int j = col-1;
        while(i>=0 && j>=0) {
            if(queen[i][j]==1){
                return false;
            }
            i--;
            j--;
        }

        //lower left diagonal
        i = row+1;
        j = col-1;
        while(i<n && j>=0) {
            if(queen[i][j]==1) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    private void printQueen(int queen[][], int n) {
        for(int i = 0;i<n;i++) {
            System.out.println();
            for(int j = 0;j<n;j++) {
                System.out.print(queen[i][j] +" ");
            }
        }
    }
}

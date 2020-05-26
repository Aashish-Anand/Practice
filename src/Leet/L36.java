package Leet;

public class L36 {
    public static void main(String[] args) {
        new L36().run();
    }

    private void run() {
        char[][] arr = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.',
                '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][] arr1 = {{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.'
                ,'.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7',
                '.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4',
                '.','.',
                '.','.','.','.'}};
        System.out.print(isValidSudoku(arr1));
    }
    private boolean isValidSudoku(char[][] arr) {

        for(int i = 0;i<9;i++) {
            for(int j = 0;j<9;j++) {
                int num = arr[i][j] - '0';
                if(num >=1 && num<=9) {
                    if(!isSafe(arr, arr[i][j], i,j )){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean isSafe(char arr[][], char ch, int row , int col) {

        System.out.println(row+" "+col);
        /*
        To check in the same row
         */
        for(int i = 0;i<9;i++) {
            if(i!=col) {
                if (arr[row][i] == ch) {
                    return false;
                }
            }
        }

        /*
        to check in the same column
         */

        for(int i = 0;i<9;i++) {
            if(i!=row) {
                if (arr[i][col] == ch) {
                    return false;
                }
            }
        }


        /*
        To check the square
         */

        int rowIndex = row - row%3;
        int colIndex = col - col%3;

        for(int i = rowIndex;i<rowIndex+3;i++) {
            for(int j = colIndex;j<colIndex+3;j++) {
                if((i!=row && j==col)||(i==row && j!=col) || (i!=row && j!=col)) {
                    if (arr[i][j] == ch) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private int[] arr() {
        return new int[]{1,4};
    }
}

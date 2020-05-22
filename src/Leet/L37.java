package Leet;

public class L37 {
    public static void main(String[] args) {
        new L37().run();
    }

    private void run() {
        char[][] arr = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.',
                '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        solveTheSudoku(arr);
    }

    private void solveTheSudoku(char[][] arr) {
        solveTheSudokuCheck(arr);

        for(int i = 0;i<9;i++) {
            System.out.println();
            for(int j = 0;j<9;j++) {
                System.out.print(arr[i][j]+" ");
            }
        }
    }

    private boolean solveTheSudokuCheck(char[][] arr) {

        int row = -1;
        int col = -1;
        boolean flag = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] == '.') {
                    row = i;
                    col = j;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        if(!flag){
            return true;
        }

        for (int i = 1; i <= 9; i++) {
            if (isSafe(arr, row, col, i) ) {
                arr[row][col] = (char) (i+48);
                if (solveTheSudokuCheck(arr)) {
                    return true;
                }
                arr[row][col] = '.';
            }
        }
        return false;
    }

    private boolean isSafe(char[][] arr, int row, int col, int num) {
        //System.out.println(row+" "+col);

        // checking the row
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] - '0' == num) {
                return false;
            }
        }

        // checking the column if it has num already present
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] - '0' == num) {
                return false;
            }
        }

        for (int i = row - (row % 3); i < row - (row % 3) + 3; i++) {
            for (int j = col - (col % 3); j < col - (col % 3)+3; j++) {
                if (arr[i][j] - '0' == num) {
                    return false;
                }
            }
        }

        return true;
    }
}

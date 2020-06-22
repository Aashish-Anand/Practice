package Leet;

public class L79 {
    public static void main(String[] args) {
        new L79().run();
    }

    private void run() {
        char board[][] = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
        System.out.println(exist(board, "DFCE"));
    }

    private boolean exist(char board[][], String word){

        int n = board.length;
        int m = board[0].length;

        boolean visited[][] = new boolean[n][m];

        int index = 0;
        for(int i= 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(word.charAt(index) == board[i][j]) {
                    visited[i][j] = true;

                    if(existUtil(board, i,j, visited, index+1, word)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean existUtil(char board[][], int i, int j, boolean visited[][], int index, String word) {

        if(index  >= word.length()){
            return true;
        }
        int x[] = {-1,0,1,0};
        int y[] = {0, -1, 0, 1};

        for(int k = 0;k<4;k++) {
            int newX = i + x[k];
            int newY = j+ y[k];
            if(isSafe(newX, newY, visited, word, index, board)) {
                visited[newX][newY] = true;
                if(existUtil(board, newX, newY,visited, index+1, word)) {
                    return true;
                }
                visited[newX][newY] = false;
            }
        }
        return false;
    }

    private boolean isSafe(int x , int y, boolean visited[][], String word, int index, char board[][]) {

        if(index >= word.length()){
            return true;
        }
        int n = board.length;
        int m = board[0].length;
        if(x>=0 && x< n && y>=0 && y <m && !visited[x][y] && word.charAt(index)== board[x][y]) {
            return true;
        }

        return false;

    }
}

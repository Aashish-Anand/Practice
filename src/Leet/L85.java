package Leet;

public class L85 {
    public static void main(String[] args) {
        new L85().run();
    }

    private void run() {
        char matrix[][] = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(maximalRectangle(matrix));
    }

    private int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int heights[] = new int[m];

        int i = 0;
        while(i < m) {
            int countOne = 0;
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == '1') {
                    countOne++;
                }
            }
            heights[i] = countOne;
        }
        
    }
}

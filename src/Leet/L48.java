package Leet;

public class L48 {
    public static void main(String[] args) {
        new L48().run();
    }

    private void run() {
        int arr[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int arr1[][] = {
                {1, 2, 3,4},
                {5, 6, 7, 8},
                {9,10,11,12},
                {13,14,15,16}
        };

        rotateImage(arr);
        rotateImage(arr1);
    }

    private void rotateImage(int matrix[][]){
        int n = matrix.length;

        for(int i = 0;i<n/2;i++) {

            int lastRow = n-1 - i;
            for(int j = 0;j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[lastRow][j];
                matrix[lastRow][j] = temp;
            }
        }

        for(int i = 0;i<n;i++) {
            for(int j = i;j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}

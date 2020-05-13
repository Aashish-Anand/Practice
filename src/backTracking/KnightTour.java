package backTracking;

import org.w3c.dom.ls.LSOutput;

public class KnightTour {
    public static void main(String[] args) {
        new KnightTour().run();
    }
    int N = 8;

    private void run() {

        int sol[][] = new int[8][8];

        /* Initialization of solution matrix */
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;

        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        sol[0][0] = 0;


        if (!solve(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return;
        } else {
            printSolution(sol);
        }

    }

    private boolean solve(int x, int y, int movei,
                          int sol[][], int xMove[],
                          int yMove[]) {

        int k, next_x, next_y;
        if (movei == N * N)
            return true;

        /* Try all next moves from the current coordinate
            x, y */
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solve(next_x, next_y, movei + 1,
                        sol, xMove, yMove)) {
                    return true;
                }
                else {
                    sol[next_x][next_y] = -1;// backtracking
                }
            }
        }

        return false;
    }

    boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 &&
                y < N && sol[x][y] == -1);
    }

    private void printSolution(int sol[][]) {

        for(int i = 0;i<N;i++) {
            System.out.println();
            for(int j = 0;j<N;j++) {
                System.out.print(sol[i][j] +" ");
            }
        }
        System.out.println();
        System.out.println();
    }
}

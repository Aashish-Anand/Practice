package Leet;

import java.util.ArrayList;
import java.util.Arrays;

/*
https://tenderleo.gitbooks.io/leetcode-solutions-/GoogleMedium/305.html
 */
public class L305_Imp {
    public static void main(String[] args) {
        new L305_Imp().run();
    }

    private void run() {
        int positions[][] = {{0, 0}, {1, 2}, {2, 1}, {0, 1}, {1, 1}};
        int n = 3;
        int m = 3;
        ArrayList<Integer> arr = findIsland2(m, n, positions);

        for (Integer a : arr) {
            System.out.println(a + " ");
        }
    }

    private ArrayList findIsland2(int m, int n, int positions[][]) {

        ArrayList<Integer> answer = new ArrayList<>();
        int lands[] = new int[m * n];
        Arrays.fill(lands, -1);

        int x[] = {0, 0, 1, -1};
        int y[] = {1, -1, 0, 0};

        int count = 0;
        for (int i = 0; i < positions.length; i++) {
            if(i==4){
                System.out.println();
            }
            int xi = positions[i][0];
            int xj = positions[i][1];

            if (lands[xi * n + xj] != -1) {
                continue;
            }
            count++;
            lands[xi * n + xj] = xi * n + xj;
            for (int index = 0; index < x.length; index++) {
                int newx = xi + x[index];
                int newy = xj + y[index];

                if (newx >= 0 && newx < m && newy >= 0 && newy < n && lands[newx * n + newy] != -1 && lands[xi * n + xj] != lands[newx * n + newy]) {
                    count--;
                    mergeIslands(lands, lands[newx * n + newy], lands[xi * n + xj]);
                }
            }
            answer.add(count);
        }

        return answer;
    }

    // we merge the curent island to the newly found island which was found previously and change the all
    // the current element child also to the newIsland and all together they form a new island
    private void mergeIslands(int lands[], int newId, int oldId) {
        for (int i = 0; i < lands.length; i++) {
            if (lands[i] == oldId) {
                lands[i] = newId;
            }
        }
    }
}

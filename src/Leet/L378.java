package Leet;

import java.util.Comparator;
import java.util.PriorityQueue;

public class L378 {
    public static void main(String[] args) {
        new L378().run();
    }

    private void run() {
        int matrix[][] = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
        matrix =new int[][] {{10, 20, 30, 40},{15, 25, 35, 45},{24, 29, 37, 48},{32, 33, 39, 50} };
        k = 7;
        System.out.println(kthSmallest(matrix, k));
    }
    private class element {
        int row;
        int col;
        int value;
        element(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

    }
    private int kthSmallest(int matrix[][],int k){

        int n = matrix.length;
        PriorityQueue<element> pq = new PriorityQueue<>(new Comparator<element>() {
            @Override
            public int compare(element o1, element o2) {
                return o1.value - o2.value;
            }
        });

        for(int i = 0;i<n;i++) {
            pq.add(new element(0, i, matrix[0][i]));
        }

        while(k>1){
            element popped = pq.poll();
            if(popped.row<n-1) {
                pq.add(new element(popped.row + 1, popped.col, matrix[popped.row + 1][popped.col]));
            }
            k--;
        }

        return pq.peek().value;
    }
}

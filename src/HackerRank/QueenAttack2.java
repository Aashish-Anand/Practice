package HackerRank;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem Url : https://www.hackerrank.com/challenges/queens-attack-2/problem
 */
public class QueenAttack2 {

    private static boolean isSafe(Set<String> set, int n, int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n && !set.contains(Integer.toString(x) + Integer.toString(y))) {
            return true;
        }
        return false;
    }

    private static int fillHorizontal(int n, Set<String> set, int x, int y) {

        int count = 0;
        //left
        for (int i = y + 1; i < n; i++) {
            if (isSafe(set, n, x, i)) {
                count++;
            } else {
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (isSafe(set, n, x, i)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private static int fillVertical(int n, Set<String> set, int x, int y) {

        int count = 0;
        //down
        for (int i = x + 1; i < n; i++) {
            if (isSafe(set, n, i, y)) {
                count++;
            } else {
                break;
            }
        }
        //up
        for (int i = x - 1; i >= 0; i--) {
            if (isSafe(set, n, i, y)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private static int fillMainDiagonal(int n, Set<String> set, int x, int y) {

        int count = 0;

        //left - up
        int i = x-1;
        int j = y-1;
        while(i >= 0 && j>=0) {
            if(isSafe(set,n,i,j)) {
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
        while(i <n  && j<n) {
            if(isSafe(set,n,i,j)) {
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
        while(i >=0 && j<n) {
            if(isSafe(set,n,i,j)) {
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
        while(i <n && j>=0) {
            if(isSafe(set,n,i,j)) {
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
    private static int findMoves(int n ,int k ,int queen_x, int queen_y, int obstacles[][]) {

        // Defining variables for all directions
        Set<String> set = new HashSet<String>();
        for(int i = 0;i<obstacles.length;i++) {
            set.add(Integer.toString(obstacles[i][0]-1) + Integer.toString(obstacles[i][1]-1));
        }
        int count = fillHorizontal(n, set, queen_x - 1, queen_y - 1)
                + fillVertical(n, set, queen_x - 1, queen_y - 1)
                +fillMainDiagonal(n, set, queen_x - 1, queen_y - 1);


        return count;
    }

    public static void main(String []args) {
        int n = 5;
        int k = 0;
        int queen_x = 4;
        int queen_y = 3;

        int obstacles[][] = {{5, 5}, {4, 2}, {2, 3}};
        //int obstacles[][] = {};

        System.out.println(findMoves(n, k, queen_x, queen_y, obstacles));

    }
}

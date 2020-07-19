package Leet;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L1210 {
    public static void main(String[] args) {
        new L1210().run();
    }

    private class coordinates {
        int a,b,c,d;
        int dist;
        coordinates(int a, int b, int c, int d, int dist) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.dist = dist;
        }
    }
    private void run() {
        int grid[][] = {{0,0,0,0,0,1},
               {1,1,0,0,1,0},
               {0,0,0,0,1,1},
               {0,0,1,0,1,0},
               {0,1,1,0,0,0},
               {0,1,1,0,0,0}};
        int grid1[][] = {{0,0,1,1,1,1},
               {0,0,0,0,1,1},
               {1,1,0,0,0,1},
               {1,1,1,0,0,1},
               {1,1,1,0,0,1},
               {1,1,1,0,0,0}};

        int grid2[][] = {{0,0,0,0,1,1},{1,1,0,0,0,1},{1,1,1,0,0,1},{1,1,1,0,1,1},{1,1,1,0,0,1},{1,1,1,0,0,0}};

        int grid3[][] = {{0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,0,0,1,0},{0,1,0,0,1,0,1,1,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1},{0,1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,1,0,1,1},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0},{1,0,0,0,0,0,0,1,0,0,1,0,0,0,1,1,0,0,1,1},{0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,1,0,0,0,0,1,0,1,1,0,0,0,0},{0,0,0,0,1,1,1,1,0,0,0,0,1,1,0,0,0,0,1,0},{1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,1,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0,1,1,0,0,0,1,0,0,0,0,1,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0}};

        System.out.println(minimumMoves(grid));
        System.out.println(minimumMoves(grid1));
        System.out.println(minimumMoves(grid2));
        System.out.println(minimumMoves(grid3));
    }
    private int minimumMoves(int grid[][]) {
        int n = grid.length;

        Queue<coordinates> q = new LinkedList<>();
        q.add(new coordinates(0,0,0,1,0));

        Queue<coordinates> markedTrue = new LinkedList<>();
        int minDist = Integer.MAX_VALUE;

        Set<String> hash = new HashSet<>();
        while(!q.isEmpty()) {
            int size = q.size();
            int i = 0;
            while(i<size) {

                coordinates coor = q.poll();
                int prevA = coor.a;
                int prevB = coor.b;
                int prevC = coor.c;
                int prevD = coor.d;
                int prevDist = coor.dist;

                //System.out.println("(" + prevA + "," + prevB + ") and (" + prevC + "," + prevD + ") ");

//                if(prevA == 5 && prevB == 3 && prevC==5 && prevD == 4){
//                    System.out.println();
//                }
                if (prevA == n - 1 && prevB == n - 2 && prevC == n - 1 && prevD == n - 1) {
                    return prevDist;
                }

                if(hash.contains(prevA+""+prevB+""+prevC+""+prevD)){
                    i++;
                    continue;
                }
                // case 1: snake is aligned horizontally
                if (prevA == prevC ) {
                    if(prevD+1<n && grid[prevC][prevD+1]==0){ // right
                            q.add(new coordinates(prevC, prevD, prevC, prevD + 1, prevDist + 1));
                    }
                    if(prevA+1<n && grid[prevA+1][prevB]==0 && grid[prevC+1][prevD] == 0){
                            q.add(new coordinates(prevA + 1, prevB, prevC + 1, prevD, prevDist + 1)); // horizontal down
                            q.add(new coordinates(prevA, prevB, prevA + 1, prevB, prevDist + 1));// clockwise
                    }


                }
                if(prevB == prevD) {
                    if(prevC+1<n && grid[prevC+1][prevD]==0){ // down
                            q.add(new coordinates(prevC, prevD, prevC + 1, prevD, prevDist + 1));
                    }
                    if(prevB+1<n && grid[prevA][prevB+1]==0 && grid[prevC][prevD+1] == 0){
                            q.add(new coordinates(prevA, prevB + 1, prevC, prevD + 1, prevDist + 1)); // vertical right
                            q.add(new coordinates(prevA, prevB, prevA, prevB + 1, prevDist + 1)); // anticlockwise
                    }
                }

                markedTrue.add(new coordinates(prevA, prevB, prevC, prevD, 0));
                hash.add(prevA+""+prevB+""+prevC+""+prevD);
                i++;
            }
        }
        return -1;
    }
}

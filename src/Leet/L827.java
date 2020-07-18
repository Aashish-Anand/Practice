package Leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * This is just an amazing question.
 * It has 2 solution
 * 1. Dfs but time limit exceed :
 *    in this solution you will first make any zero to one then find max area and you have to do it in the same way
 *
 * 2. Coloring Solution by ME:
 *    In this solution we first traverse the whole matrix and color each island with diffrent color
 *    eg if we have 0,0,1,1
 *                  0,0,1,1
 *                  1,1,0,0
 *                  1,1,0,0
 *    then it will be look like  0,0,10,10
 *                               0,0,10,10
 *                               20,20,0,0
 *                               20,20,0,0
 *    number other than 0 and 1 is color; also stores the area associated with it i.e 10 has 4 and 20 has 4 area size.
 *
 *    Now what we can do is, for every zero - check all its adjacent i.e up, down, right, left and if they are colored
 *    then just find add the area and side by side check the area with max area.
 *
 *    at the end return the max area as answer;
 *
 */
public class L827 {
    public static void main(String[] args) {
        new L827().run();
    }

    private void run() {
        int grid[][] = {{1,1,1,1},{1,0,0,1},{1,0,0,1},{1,1,1,1}};
        System.out.println(largestIsland(grid));

        int grid1[][] = {{1,1,0,0,1,1,1},{1,1,0,0,1,1,1},{1,1,0,0,1,1,1},{0,0,1,1,0,0,0},{0,0,1,1,0,0,0}};
        System.out.println(largestIsland(grid1));

        int grid2[][] = {{1}};
        System.out.println(largestIsland(grid2));
    }

    int maxSize = 0;
    int size = 0;
    int maxArea = 0;
    private int largestIsland(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];

        maxArea = 0;
        maxSize = 0;
        size = 0;
        int color = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    color = color+10;
                    size = 0;
                    DFS(grid, i,j, visited, color);
                    //System.out.println(size);
                    hash.put(color, size);
                }
            }
        }


        int area = 0;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(grid[i][j] == 0){
                    Set<Integer> set = new HashSet<>();
                    area+=1;
                    int moveH[] = {-1,0,1,0};
                    int moveV[] = {0,-1,0,1};
                    for(int index = 0;index<4;index++) {
                        int newx = i+moveH[index];
                        int newy = j+moveV[index];
                        if(newx >=0 && newx<grid.length && newy >=0 && newy<grid[0].length && grid[newx][newy]!=0) {
                            if(!set.contains(grid[newx][newy])) {
                                area += hash.get(grid[newx][newy]);
                                set.add(grid[newx][newy]);
                            }
                        }
                    }
                    if(area > maxArea){
                        maxArea = area;
                    }
                    area = 0;
                }

            }
        }
        return maxArea;
    }

    private void DFS(int grid[][], int x, int y , boolean visited[][], int color) {
        int moveH[] = {-1,0,1,0};
        int moveV[] = {0,-1,0,1};

        size=size+1;
        if(maxSize < size){
            maxSize = size;
            if(maxSize>maxArea){
                maxArea = maxSize;
            }
        }
        grid[x][y] = color;
        visited[x][y] = true;

        for(int i = 0;i<4;i++) {
            int newx = x+moveH[i];
            int newy = y+moveV[i];
            if(newx >=0 && newx<grid.length && newy >=0 && newy<grid[0].length && !visited[newx][newy]&& grid[newx][newy]==1) {
                DFS(grid, newx, newy, visited, color);
            }
        }
    }
}

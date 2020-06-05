package Leet;

public class L200 {
    public static void main(String[] args) {
        new L200().run();
    }

    private void run() {
//        char grid[][] = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','1',
//                '0','1'}};

        char grid[][] = {};
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(findIsland(grid));
    }

    private int findIsland(char grid[][]) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean visited[][] = new boolean[rows][cols];

        int count = 0;
        for(int i = 0;i<rows;i++) {
            for(int j = 0;j<cols;j++) {
                if(!visited[i][j] && grid[i][j]=='1'){
                    checkIsland(visited,grid, i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void checkIsland(boolean visited[][], char grid[][], int i, int j) {

        visited[i][j] = true;
        int x[] = {0,0,1,-1};
        int y[] = {1,-1,0,0};

        for(int index = 0;index<x.length;index++) {
            int newx = i+x[index];
            int newy = j+y[index];
            if(isSafe(newx, newy, grid,grid.length, grid[0].length, visited)){
                checkIsland(visited,grid,newx, newy);
            }
        }
    }

    private boolean isSafe(int newx, int newy, char grid[][], int rows, int cols , boolean visited[][]) {
        if(newx>=0 && newx<rows && newy>=0 && newy<cols && grid[newx][newy]=='1' && !visited[newx][newy]){
            return true;
        }
        return false;
    }

}

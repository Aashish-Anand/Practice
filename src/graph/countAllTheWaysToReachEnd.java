package graph;

public class countAllTheWaysToReachEnd {
    public static void main(String[] args) {
        new countAllTheWaysToReachEnd().run();
    }

    private void run() {
        // 0 is the path and -1 is the obstacle
        int maze[][] = {{0,0,0,0},{0,-1,0,0},{-1,0,0,0},{0,0,0,0}};

        System.out.println(findPath(maze));
    }

    int n;
    int m;
    int numberOfPaths;
    private int findPath(int maze[][]){
        n = maze.length;
        m = maze[0].length;

        letsStart(maze, 0,0);
        return numberOfPaths;
    }

    private void letsStart(int maze[][], int i, int j){
        if(i == n-1 && j == m-1){
            numberOfPaths++;
            return;
        }
        // down check
        if(i+1>=0 && i+1<n && j>=0 && j<m && maze[i+1][j]!=-1){
            letsStart(maze, i+1,j);
        }

        // right check
        if(i>=0 && i<n && j+1>=0 && j+1<m && maze[i][j+1]!=-1){
            letsStart(maze, i,j+1);
        }
    }
}

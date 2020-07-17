package graph;

public class countAllTheWaysToReachEndDP {
    public static void main(String[] args) {
        new countAllTheWaysToReachEndDP().run();
    }
    private void run() {
        // 0 is the path and -1 is the obstacle
        int maze[][] = {{0,0,0,0},{0,-1,0,0},{-1,0,0,0},{0,0,0,0}};
        System.out.println(letsFindTheWayOut(maze));
    }

    private int letsFindTheWayOut(int maze[][]) {
        if(maze[0][0] == -1){
            return 0;
        }
        int r = maze.length;
        int c = maze[0].length;

        for(int i = 0;i<c;i++) {
            if(maze[0][i]==0){
                maze[0][i] = 1;
            }
            else{
                break;
            }
        }

        for(int i = 0;i<r;i++) {
            if(maze[i][0] == 0){
                maze[i][0] = 1;
            }
            else{
                break;
            }
        }

        for(int i = 1;i<r;i++) {
            for(int j = 1;j<c;j++) {
                if(maze[i][j] == -1){
                    continue;
                }

                if(maze[i-1][j]>0){
                    maze[i][j] = maze[i][j]+maze[i-1][j];
                }
                if(maze[i][j-1]>0){
                    maze[i][j] = maze[i][j]+maze[i][j-1];
                }
            }
        }
        return maze[r-1][c-1]!=-1?maze[r-1][c-1]:0;
    }
}

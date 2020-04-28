package graph;

/**
 * Tutorial I Followed : https://www.techiedelight.com/pairs-shortest-paths-floyd-warshall-algorithm/
 */
public class FloydWarshell {
    public static void main(String[] args) {
        new FloydWarshell().run();
    }

    private void run() {

        int N = 4;
        int M = Integer.MAX_VALUE;

        int[][] adjMatrix = new int[][]{
                {0, M, -2, M},
                {4, 0, 3, M},
                {M, M, 0, 2},
                {M, -1, M, 0}
        };

        FloydWarshellAlgo(adjMatrix, N);
    }

    private void FloydWarshellAlgo(int adj[][], int n) {

        int cost[][] = new int[n][n];
        int path[][] = new int[n][n];

        /*
        Initializing the cost and path matrix
         */
        for (int v = 0; v < n; v++) {
            for (int u = 0; u < n; u++) {
                cost[v][u] = adj[v][u];

                if (v == u) {
                    path[v][u] = 0;
                } else if (cost[v][u] != Integer.MAX_VALUE) {
                    path[v][u] = v;
                } else {
                    path[v][u] = -1;
                }
            }
        }

        //running the floyd warshell algo

        for(int k = 0;k<n;k++) {
            for(int v = 0;v<n;v++) {
                for(int u = 0;u<n;u++) {

                    if(cost[v][k]!= Integer.MAX_VALUE
                            && cost[k][u]!=Integer.MAX_VALUE
                            && cost[v][k]+cost[k][u] < cost[v][u]) {
                        cost[v][u] = cost[v][k]+cost[k][u];
                        path[v][u] = path[k][u];
                    }

                    if(cost[v][v]<0){
                        System.out.println("Negative weight cycle found.");
                        return;
                    }
                }
            }
        }

        printSolution(cost, path, n);
    }

    private void printSolution(int cost[][],int path[][],int n) {

        for(int v = 0;v<n;v++) {
            for(int u = 0;u<n;u++) {
                if(u!=v && path[v][u]!= -1) {
                    System.out.print("Shortest Path from vertex " + v +" to vertex "+ u + " is ( "+ v + " ");
                    printPath(path, v,u);
                    System.out.println(u+" )");
                }
            }
        }
    }

    private void printPath(int path[][], int v, int u) {
        if(path[v][u] == v){
            return;
        }
        printPath(path, v, path[v][u]);
        System.out.print(path[v][u] +" ");
    }
}

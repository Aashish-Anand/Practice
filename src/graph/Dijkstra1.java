package graph;

/**
 * Dijsktra using the Adjacency Matrix
 */

public class Dijkstra1 {
    public static void main(String[] args) {
        new Dijkstra1().run();
    }

    private void run() {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        dijkstraShortestPath(graph, 0);
    }

    private void dijkstraShortestPath(int graph[][], int source) {

        int noOfVerticex = graph.length;

        int distance[] = new int[noOfVerticex];

        distance[source] = 0;

        boolean set[] = new boolean[noOfVerticex];

        for(int i = 0;i<noOfVerticex)
    }
}

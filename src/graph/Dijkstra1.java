package graph;

/**
 * Dijsktra using the Adjacency Matrix
 */

public class Dijkstra1 {
    public static void main(String[] args) {
        new Dijkstra1().run();
    }

    private void run() {
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        dijkstraShortestPath(graph, 0);
    }

    private void dijkstraShortestPath(int graph[][], int source) {

        int noOfVerticex = graph.length;

        int distance[] = new int[noOfVerticex];

        boolean alreadyVisitedVertex[] = new boolean[noOfVerticex];

        for (int i = 0; i < noOfVerticex; i++) {
            distance[i] = Integer.MAX_VALUE;
            alreadyVisitedVertex[i] = false;
        }
        distance[source] = 0;
        /*
        We need to iterate over each vertex
         */
        for (int i = 0; i < noOfVerticex - 1; i++) {

            /*
            Picking the minimum distance vertex among the non visited vertex
             */
            int u = findMinimum(alreadyVisitedVertex, distance);

            alreadyVisitedVertex[u] = true;

            for (int j = 0; j < noOfVerticex; j++) {
                if (graph[u][j] != 0 && distance[u] != Integer.MAX_VALUE && distance[j] > distance[u] + graph[u][j]) {
                    distance[j] = distance[u] + graph[u][j];
                }
            }
        }
        printDistances(distance);
    }

    private int findMinimum(boolean alreadyVisitedVertex[], int distance[]) {

        int n = alreadyVisitedVertex.length;
        int minIndex = 0;
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (!alreadyVisitedVertex[i]) {
                if (distance[i] < minDis) {
                    minDis = distance[i];
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }

    private void printDistances(int distance[]) {
        System.out.println("Shortest Distance From Sources ");
        System.out.println("Sources " + "\t\t" + " Distance");
        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + "\t\t\t\t " + distance[i]);
        }
    }
}

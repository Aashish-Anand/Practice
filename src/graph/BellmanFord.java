package graph;

import java.util.Arrays;
import java.util.List;

/**
 * Single Source Shortest Path
 */
class Edge {
    int source;
    int destination;
    int weight;

    Edge(int s, int d, int w) {
        source = s;
        destination = d;
        weight = w;
    }
}

public class BellmanFord {
    public static void main(String[] args) {
        new BellmanFord().run();
    }

    private void run() {

        List<Edge> edges = Arrays.asList(new Edge(0, 1, -1), new Edge(0, 2, 4),
                new Edge(1, 2, 3), new Edge(1, 4, 2),
                new Edge(1, 3, 2), new Edge(3, 1, 1),
                new Edge(3, 2, 5), new Edge(4, 3, -3));

        int vertices = 5;
        int source = 0;

        bellmanFord(edges, source, vertices);
    }

    private void bellmanFord(List<Edge> edges, int source, int vertices) {

        int E = edges.size();

        int distance[] = new int[vertices];
        int parent[] = new int[vertices];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        Arrays.fill(parent, -1);

        int k = vertices;

        while (--k > 0) {

            for (int i = 0; i < E; i++) {

                int u = edges.get(i).source;
                int v = edges.get(i).destination;
                int w = edges.get(i).weight;

                if (distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + w) {
                    distance[v] = distance[u] + w;
                    parent[v] = u;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            int u = edges.get(i).source;
            int v = edges.get(i).destination;
            int w = edges.get(i).weight;

            if (distance[v] > distance[u] + w) {
                System.out.println("There exists a negative edge in graph...");
                return;
            }
        }

        for (int i = 0; i < vertices; i++) {
            System.out.print("Distance of vertex " + i + " from the source is " + distance[i] +
                    ". It path is [ ");

            printPath(i, parent);
            System.out.println("]");
        }
    }

    private void printPath(int u, int parent[]) {
        if (u<0) {
            return;
        }

        printPath(parent[u], parent);
        System.out.print(u + " ");
    }
}

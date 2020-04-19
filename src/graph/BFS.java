package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */

class Graph{
    int V;
    LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[V];

        for(int i = 0;i<V;i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

}
public class BFS {
    public static void main(String[] args) {
        new BFS().run();
    }

    Graph g;
    private void run() {

        g = new Graph(9);
        g.addEdge(0,1);
        g.addEdge(0,7);
        g.addEdge(1,2);
        g.addEdge(1,7);
        g.addEdge(2,3);
        g.addEdge(2,8);
        g.addEdge(2,5);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(4,5);
        g.addEdge(5,6);
        g.addEdge(6,8);
        g.addEdge(6,7);
        g.addEdge(7,8);

        BFS(g.V);
    }

    private void BFS(int noOfVertices) {

        boolean visited[] = new boolean[noOfVertices];

        //visited[source] = true;

        for(int i = 0;i<noOfVertices;i++) {
            if(!visited[i]) {
                printDFS(i,visited);
            }
        }
    }

    private void printDFS(int v, boolean visited[]) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited[v]=true;

        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex +" ");

            for(Integer currVertex : g.adj[vertex]){
                if(!visited[currVertex]) {
                    queue.add(currVertex);
                    visited[currVertex] = true;
                }
            }
        }
    }
}

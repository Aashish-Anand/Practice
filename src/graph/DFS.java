package graph;

public class DFS {
    public static void main(String[] args) {
        new DFS().run();
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
        g.addEdge(6,7);
        g.addEdge(6,8);
        g.addEdge(7,8);

        DFS(0, g.V);
    }

    private void DFS(int source, int noOfVertices) {

        boolean visited[] = new boolean[noOfVertices];

        for(int i = 0;i<noOfVertices;i++) {
            if(!visited[i]) {
                printDFS(i,visited);
            }
        }
    }

    private void printDFS(int vertex, boolean visited[]) {

        visited[vertex] =true;
        System.out.print(vertex + " ");

        for(Integer currVertex : g.adj[vertex]) {
            if(!visited[currVertex]) {
                printDFS(currVertex, visited);
            }
        }
    }
}

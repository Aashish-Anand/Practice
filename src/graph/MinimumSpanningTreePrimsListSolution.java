package graph;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class MinimumSpanningTreePrimsListSolution {

    // data of a particular node
    class node {
        int dest;
        int weight;
        node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    //data of a graph
    class Graph {
        int V;

        LinkedList<node> adjList[];
        Graph(int V) {

            this.V = V;

            adjList = new LinkedList[V];

            for(int i =0;i<V;i++) {
                adjList[i] = new LinkedList<>();
            }
        }
    }

    class nodeForQueue {
        int vertex;
        int key;  // this is actually the weight
    }

    /**
     * return 1 if node1.key > node2.key
     * return 0 if node1.key == node2.key
     * return -1 of node1.key < node2.key
     */
    class comparator implements Comparator<nodeForQueue> {

        @Override
        public int compare(nodeForQueue node1, nodeForQueue node2) {
            return node1.key - node2.key;
        }
    }

    private void addEdge(Graph g, int source , int dest, int weight) {

        node n1 = new node(source, weight);   // as it is an undirected graph
        node n2 = new node(dest, weight);

        g.adjList[source].addLast(n2);   // from u to v;
        g.adjList[dest].addLast(n1);     // from v to u;
    }

    private void findMST(Graph graph) {

        int v = graph.V;

        int parent[] = new int[graph.V];
        Boolean isInMST[] = new Boolean[graph.V];

        nodeForQueue queueNode[] = new nodeForQueue[graph.V];

        for(int i = 0;i<v;i++) {
            queueNode[i] = new nodeForQueue();
        }

        for(int i = 0;i<v;i++) {
            isInMST[i] = false;
            queueNode[i].key = Integer.MAX_VALUE;
            queueNode[i].vertex = i;

            parent[i] = -1;
        }

        isInMST[0] = true;

        queueNode[0].key = 0;  // source node has weight 0;

        TreeSet<nodeForQueue> queue = new TreeSet<>(new comparator());

        for(int i = 0;i<v;i++) {
            queue.add(queueNode[i]);
        }

        while(!queue.isEmpty()) {

            nodeForQueue u = queue.pollFirst();

            isInMST[u.vertex] = true;

            // we are iterating over to its adjacent vertices which are
            // not in MST right now and also updated its weight
            for(node itr : graph.adjList[u.vertex]) {

                    if(isInMST[itr.dest]==false) {

                        /**
                         * First removing the vertex then adding again the updated vertex
                         */
                        if(queueNode[itr.dest].key > itr.weight) {

                            queue.remove(queueNode[itr.dest]);
                            queueNode[itr.dest].key = itr.weight;
                            queue.add(queueNode[itr.dest]);
                            parent[itr.dest] = u.vertex;
                        }
                    }
            }
        }

        System.out.println("Parent    Child");
        for(int i = 1;i<v;i++) {
            System.out.println("   "+parent[i] +"   - \t" +i);
        }
    }


    private void run() {

        int V = 9;
        Graph graph = new Graph(V);

        addEdge(graph, 0, 1, 4);
        addEdge(graph, 0, 7, 8);
        addEdge(graph, 1, 2, 8);
        addEdge(graph, 1, 7, 11);
        addEdge(graph, 2, 3, 7);
        addEdge(graph, 2, 8, 2);
        addEdge(graph, 2, 5, 4);
        addEdge(graph, 3, 4, 9);
        addEdge(graph, 3, 5, 14);
        addEdge(graph, 4, 5, 10);
        addEdge(graph, 5, 6, 2);
        addEdge(graph, 6, 7, 1);
        addEdge(graph, 6, 8, 6);
        addEdge(graph, 7, 8, 7);


        findMST(graph);
    }

    public static void main(String[] args) {
        new MinimumSpanningTreePrimsListSolution().run();
    }
}

package graph;

public class MinimumSpanningTreePrimMatrixSolution {
    public static void main(String[] args) {
        new MinimumSpanningTreePrimMatrixSolution().run();
    }

    private void run() {
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        findMST(graph);
    }

    private void findMST(int graph[][]) {
        int n = graph.length;

        int parent[] = new int[n];
        int weightOfVertex[] = new int[n];

        boolean isInMST[] = new boolean[n];

        for(int i = 0;i<n;i++) {
            weightOfVertex[i] = Integer.MAX_VALUE;
            isInMST[i] = false;
        }


        parent[0] = -1;
        // make sure that this vertex will be picked first
        weightOfVertex[0] = 0;


        // iterate for number of times equals to number of vertex
        for(int count = 0;count<n-1;count++) {

            int u = findMinimumWeightVertex(weightOfVertex, isInMST);

            isInMST[u] = true;

            for(int v = 0; v<n;v++) {
                if(graph[u][v]!=0  && isInMST[v] == false && weightOfVertex[v]> graph[u][v]) {
                    weightOfVertex[v] = graph[u][v];
                    parent[v] = u;
                }
            }

        }

        printMST(parent, graph,n);
    }

    /*
    Return the vertex with minimum weight associated with it
     */
    private int findMinimumWeightVertex(int weightOfVertex[], boolean isInMst[]) {

        int minimumWeight = Integer.MAX_VALUE;
        int pos = -1;
        for(int i = 0;i<weightOfVertex.length;i++) {
            if(weightOfVertex[i]<minimumWeight && !isInMst[i]){
                minimumWeight = weightOfVertex[i];
                pos = i;
            }
        }
        return pos;
    }

    private void printMST(int parent[], int graph[][], int n) {

        System.out.println("Edges \t Weight");
        for(int i = 1;i<n;i++) {   // we are starting from 1 because 0 is parent of his own
            System.out.println(parent[i]+" -> "+i + "\t   " +graph[i][parent[i]]);
        }
    }
}

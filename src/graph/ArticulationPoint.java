package graph;

import java.util.Arrays;
import java.util.LinkedList;

class artiGraph {
    int V;
    LinkedList<Integer> adj[];

    artiGraph(int v) {
        V = v;
        adj = new LinkedList[v];

        for(int i = 0;i<v;i++) {
            adj[i] = new LinkedList<>();
        }
    }
    void addEdge(int u, int v) {
        --u;
        --v;
        adj[u].add(v);
        adj[v].add(u);
    }

}
public class ArticulationPoint {
    public static void main(String[] args) {
        new ArticulationPoint().run();
    }

    artiGraph g;
    private void run() {
        int v = 6;
        g = new artiGraph(v);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(4,6);
        g.addEdge(5,6);


        findAndPrintArticulationPoint(0, v);
    }

    int discovery[];
    int lowest[];
    int parent[];

    int lowestParent = -1;
    int discoveryTime = 0;
    boolean ap[];

    private void findAndPrintArticulationPoint(int source, int n) {
        boolean vis[] = new boolean[n];
        discovery = new int[n];
        lowest = new int[n];
        parent = new int[n];
        ap = new boolean[n];
        parent[source]= -1;
        for(int i = 0;i<n;i++) {
            if(!vis[source]){
                DFSUtil(source, vis);
            }
            if(!vis[i]) {
                DFSUtil(i, vis);
            }
        }

        System.out.println();

        for (int i = 0;i<ap.length;i++) {
            if(ap[i]) {
                System.out.print(i+1 + " ");
            }
        }
    }

    private void DFSUtil(int u, boolean vis[]) {

        discovery[u] =lowest[u]= ++discoveryTime;
        System.out.println(u+1);
        vis[u] = true;
        int child = 0;
        for(Integer v : g.adj[u]) {

            if(!vis[v]) {
                child++;
                parent[v] = u;
                DFSUtil(v,vis);

                lowest[u] = Math.min(lowest[u], lowest[v]);

                if(child>1 && parent[u]==-1) {
                    ap[u] = true;
                }
                if(parent[u]!=-1 && lowest[v]>=discovery[u]) {
                    ap[v] = true;
                    ap[u] = true;
                    System.out.println(discovery[u] +" "+ lowest[v]);
                }
            }
            else if(v!=parent[u]){
                lowest[u] = Math.min(lowest[u],discovery[v]);
            }

        }
    }
}

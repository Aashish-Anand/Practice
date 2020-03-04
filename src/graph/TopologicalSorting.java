package graph;

import java.util.LinkedList;
import java.util.Stack;

/*
 * We Use DFS technique here
 * 
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u-v,
 * vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
 * For example, a topological sorting of the following graph is “5 4 2 3 1 0”. 
 * There can be more than one topological sorting for a graph.
 * For example, another topological sorting of the following graph is “4 5 2 3 1 0”. 
 * The first vertex in topological sorting is always a vertex with in-degree as 0 (a vertex with no incoming edges).
 */
public class TopologicalSorting {

	int V;
	LinkedList<Integer> adj[];

	@SuppressWarnings({ "unchecked", "rawtypes" })
	TopologicalSorting(int v) {
		V = v;
		adj = new LinkedList[V];

		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList();
		}
		
	}

	void addEdge(int a, int b) {
		adj[a].add(b);
	}

	void topologicalSortUtil(int i, Stack<Integer> stack, boolean vis[]) {

		LinkedList<Integer> l = adj[i];
		if (l.isEmpty()) {
			stack.add(i);
			vis[i] = true;
		} else {
			for (Integer itr : l) {
				if (!vis[itr]) {
					topologicalSortUtil(itr, stack, vis);
				}
			}
			stack.add(i);
			vis[i] = true;
		}
	}

	void topologicalSort() {

		boolean vis[] = new boolean[V];
		Stack<Integer> s = new Stack<>();

		for (int i = V - 1; i > 0; i--) {
			if (vis[i] == false) {
				topologicalSortUtil(i, s, vis);
			}
		}

		while (!s.isEmpty()) {
			System.out.print(s.peek() + " ");
			s.pop();
		}
	}

	public static void main(String[] args) {

		TopologicalSorting g = new TopologicalSorting(6);

		g.addEdge(5, 0);
		g.addEdge(5, 2);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		g.topologicalSort();
	}

}

package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * We use BFS Technique here
 * 
 * This is the problem of finding the minimum 
 * number of step required to reach to the
 * destination from the starting index.
 * 
 */
public class StepsByKnight {

	static class Point {
		int x, y;

		int dist;

		Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public static boolean isSafe(int n, int x, int y, boolean vis[][]) {

		if (x >= 0 && y >= 0 && x < n && y < n && !vis[x][y]) {
			return true;
		}
		return false;
	}

	public static int findShortestPath(int n, int start_x, int start_y, int end_x, int end_y, boolean vis[][]) {

		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(start_x,start_y, 0));
		
		vis[start_x][start_y] = true;
		
		int row[] = { -2, -2, -1, 1, -1, 1, 2, 2 };
		int col[] = { -1, 1, 2, 2, -2, -2, -1, 1 };

		while(!queue.isEmpty()) {
			Point p = queue.peek();
			queue.poll();
			
			//System.out.println(p.x + " " +p.y);
			if(p.x == end_x && p.y == end_y) {
				return p.dist;
			}
			
			for (int i = 0; i < 8; i++) {
				int new_x = p.x + row[i];
				int new_y = p.y + col[i];
				if(isSafe(n,new_x,new_y,vis)) {
					vis[new_x][new_y] = true;
					queue.add(new Point(new_x, new_y, p.dist+1));
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			
			int start_x = sc.nextInt();
			int start_y = sc.nextInt();
			
			int end_x = sc.nextInt();
			int end_y = sc.nextInt();
			
			boolean vis[][] = new boolean[n][n];
			
			System.out.println(findShortestPath(n, start_x, start_y, end_x, end_y, vis));
		}
		sc.close();
		
	}

}

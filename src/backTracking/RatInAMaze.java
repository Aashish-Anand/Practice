package backTracking;

import java.util.ArrayList;

public class RatInAMaze {

	public static boolean isSafe(int m[][], boolean vis[][], int i, int j, int n) {
		if (i >= 0 && j >= 0 && i < n && j < n && m[i][j] == 1 && !vis[i][j]) {
			return true;
		}
		return false;
	}

	public static void findPath(int[][] m, int n, int i, int j, boolean[][] vis, ArrayList<String> arr, String str) {
		if (i == n - 1 && j == n - 1) {
			arr.add(str);
			vis[i][j] = false;
			return;
		}

		if (isSafe(m, vis, i, j, n)) {
			/*
			 * Marking the position as True
			 */
			vis[i][j] = true;
			
			/*
			 * Iterating Down
			 */
			str += "D";
			findPath(m, n, i + 1, j, vis, arr, str);
			str = str.substring(0, str.length() - 1);

			/*
			 * Iterating Left
			 */
			str += "L";
			findPath(m, n, i, j - 1, vis, arr, str);
			str = str.substring(0, str.length() - 1);

			/*
			 * Iterating Right
			 */
			str += "R";
			findPath(m, n, i, j + 1, vis, arr, str);
			str = str.substring(0, str.length() - 1);

			/*
			 * Iterating Up
			 */
			str += "U";
			findPath(m, n, i - 1, j, vis, arr, str);
			str = str.substring(0, str.length() - 1);

			/*
			 * BackTracking
			 */
			vis[i][j] = false;
		}

	}

	public static ArrayList<String> printPath(int[][] m, int n) {
		// Your code here
		boolean vis[][] = new boolean[n][n];
		ArrayList<String> arr = new ArrayList<>();
		String str = "";
		findPath(m, n, 0, 0, vis, arr, str);
		return arr;
	}

	public static void main(String[] args) {

		int[][] m = { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 1 } };
		int n = 3;

		ArrayList<String> arr = printPath(m, n);
		System.out.println(arr.toString());
	}

}

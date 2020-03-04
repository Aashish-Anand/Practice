package backTracking;

import java.util.Scanner;

/*
 * 
 * Print all combination of the queen
 	Input
	2
	1
	4
	Output:
	[1 ]
	[2 4 1 3 ] [3 1 4 2 ]
 */
public class NQueenPrintAllPermutations {

	static boolean flag = false;;
	public static boolean isSafe(int n, int row, int col, boolean vis[][]) {

		/*
		 * This is to check if any queen lies in the same row
		 */
		for (int i = row - 1; i >= 0; i--) {
			if (vis[i][col]) {
				return false;
			}
		}

		/*
		 * To check left upper diagonal
		 */
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (vis[i][j]) {
				return false;
			}
		}

		/*
		 * To check the right upper diagonal
		 */
		for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
			if (vis[i][j]) {
				return false;
			}
		}

		return true;
	}
    static int count = 0;
	public static boolean allPossibleNQueen(int n, int row, boolean vis[][]) {
		if (row == n) {
			flag = true;
			if(count == 0){
    			System.out.print("[");
    			count++;
			}
			else{
			    System.out.print(" [");
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(vis[i][j]) {
						System.out.print((j+1)+" ");
					}
				}
			}
			System.out.print("]");
			return false;
		}
		
		//boolean res = false;
		for (int i = 0; i < n; i++) {
			if (isSafe(n, row, i, vis)) {
				vis[row][i] = true;

				if (allPossibleNQueen(n, row + 1, vis) == true) {
					return true;
				}

				vis[row][i] = false;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t-- > 0) {
			flag = false;
			int n = sc.nextInt();
            count = 0;
			boolean vis[][] = new boolean[n][n];

			allPossibleNQueen(n, 0, vis);
			if(!flag) {
				System.out.print("-1");
			}
			System.out.println();

		}
		sc.close();
	}

}

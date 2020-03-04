package graph;

import java.util.Arrays;

public class Nearest1ForEachIndex {

	public boolean isSafe(int i, int j, int row, int col, boolean vis[][]) {
		if(i>=0 && j>=0 && i<row && j<col && !vis[i][j]) {
			return true;
		}
		return false;
	}
	public boolean find(int arr[][],int orgi, int orgj, int i, int j, int row, int col, int distance,boolean vis[][], int mat[][]) {
		
		if(arr[i][j] == 1) {
			dist = distance;
			if(mat[orgi][orgj] > dist) {
				mat[orgi][orgj] = dist;
			}
			return true;
		}
		vis[i][j] = true;
		int new_x[] = {-1, 0, 1, 0};  // U L D R
		int new_y[] = {0, -1, 0, 1};
		
		for(int k = 0;k<4;k++) {
			int new_i = i + new_x[k];
			int new_j = j + new_y[k];
			
			if(isSafe(new_i, new_j, row, col, vis)) {
				find(arr,orgi,orgj,new_i, new_j,row, col, distance+1, vis, mat);
			}
			
		}
		vis[i][j] = false;
		return false;
	}
	
	int dist = 0;
	public void findNearest1(int arr[][], int row, int col) {
		
		int mat[][] = new int[row][col];
		
		for(int[] i:mat) {
			Arrays.fill(i, Integer.MAX_VALUE);
		}
		boolean vis[][] = new boolean[row][col];
		for(int i = 0;i<row; i++) {
			for(int j = 0;j<col;j++) {
				if(arr[i][j] == 1) {
					mat[i][j] = 0;
				}
				else {
					dist = 0;
					find(arr,i,j,i,j,row,col,dist,vis,mat);
				}
			}
		}
		
		for(int i = 0;i<row;i++) {
			for(int j = 0;j<col;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		int arr[][] = {{1,0,1},{0,0,0},{0,0,1}};
		//int arr[][] = {{0,0},{0,1}};
		int row = arr.length;
		int col = arr[0].length;
		int flag =0;
		for(int i = 0;i<row;i++) {
			for(int j = 0;j<col;j++) {
				if(arr[i][j] == 1) {
					flag =1;
					break;
				}
			}
			if(flag ==1) {
				break;
			}
		}
		
		if(flag == 1) {
			Nearest1ForEachIndex n = new Nearest1ForEachIndex();
			n.findNearest1(arr,row,col);
		}
		else {
			System.out.print("No Solution");
		}
		
	}

}

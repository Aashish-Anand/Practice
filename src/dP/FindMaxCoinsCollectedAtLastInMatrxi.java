package dP;

public class FindMaxCoinsCollectedAtLastInMatrxi {

	/*
	 * Given a matrix having the number of coins at each index you have to find out
	 * the maximum number of coins at index M*N
	 * you can move to only right and down
	 * 
	 */
	public static void main(String[] args) {
		int arr[][] = {{0,0,3,2},{1,2,3,3},{6,2,3,3}};
		
		int rows = arr.length;
		int cols = arr[0].length;
		System.out.println(rows+" " + cols);
		for(int i = 1;i<rows;i++) {
			arr[i][0] += arr[i-1][0];
		}
		
		for(int i = 1;i<cols;i++) {
			arr[0][i] += arr[0][i-1];
		}
		
		for(int i = 1;i<rows;i++) {
			for(int j = 1;j<cols;j++) {
				arr[i][j] += Math.max(arr[i-1][j],arr[i][j-1]);
			}
		}
		
		for(int i = 0;i<rows;i++) {
			for(int j = 0;j<cols;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}

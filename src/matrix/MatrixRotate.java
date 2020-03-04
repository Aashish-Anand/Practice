package matrix;

public class MatrixRotate {

	public static void main(String[] args) {
		int mat[][] = {{1,2,3},
						{5,6,7},
						{9,10,11}};
		
		int n = mat[0].length;
		System.out.println(n);
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n/2;j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[i][n-j-1];
				mat[i][n-j-1] = temp;
			}
		}
		
		for(int i = 0;i<=n-2;i++) {
			for(int j = 0;j<n-i-1;j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[n-j-1][n-i-1];
				mat[n-j-1][n-i-1] = temp;
			}
		}
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

}

package dP;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String first = "john";
		String second = "johanna";
		
		int len1 = first.length();
		int len2 = second.length();
		
		int matrix[][] = new int[len1+1][len2+1];
		
		for(int i = 0;i<len1;i++) {
			matrix[len1][0] = 0;
		}
		for(int i = 0;i<len2;i++) {
			matrix[0][len2] = 0;
		}
		
		for(int i = 1;i<len1+1;i++) {
			for(int j = 1;j<len2+1;j++) {
				if(first.charAt(i-1) == second.charAt(j-1)) {
					matrix[i][j] = matrix[i-1][j-1] +1;
				}
				else {
					matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
				}
			}
		}
		System.out.println(matrix[len1][len2]);
		for(int i =0;i<len1+1;i++) {
			for(int j = 0;j<len2+1;j++) {
				System.out.print(matrix[i][j] +" ");
			}
			System.out.println();
		}
		
		System.out.println(matrix[len1][len2] == len1 ? "YES":"NO");
		
		
	}

}

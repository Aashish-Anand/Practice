package practice;

import java.util.HashSet;
import java.util.Set;

/*
 * 		 [[1, 1, 1, 0], 
          [0, 5, 0, 1], 
          [2, 1, 3, 10]]
          
          Sum is : 1+1+1+5+1 = 9
 */
public class MatrixSum {

	public static void main(String[] args) {
		int arr[][] = {{1,1,1,0},{0,5,0,1},{2,1,3,10}};
		
		int row = arr.length;
		int col = arr[0].length;
		
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		for(int i = 0;i<row;i++) {
			for(int j = 0;j<col;j++) {
				if(arr[i][j] == 0) {
					set.add(j);
				}
				if(!set.contains(j)) {
					sum+=arr[i][j];
				}
			}
		}
		System.out.println(sum);
	}

}

package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 
Input:
2
7
10 1 2 7 6 1 5
8
5
8 1 8 6 8
12

Output:
(1 1 6)(1 2 5)(1 7)(2 6)
Empty

 */
public class CombinationSum {

	static int findCombinationflag = 0;
	public static void findCombinations(int[] arr, int i ,
			int n , ArrayList<Integer> temp, int sum) {
		
		if(sum < 0) {
			return;
		}
		if(sum == 0) {
		    findCombinationflag =1;
            int count = 0;
            
			System.out.print("(");
			for(Integer a : temp) {
				if(count == 0) {
					count = 1;
					System.out.print(a);
				}else {
				System.out.print(" "+a);
				}
			}
			System.out.print(")");
			
			return;
		}
		
		if(i>=n) {
			return;
		}
	
		temp.add(arr[i]);
		findCombinations(arr, i+1, n, temp, sum-arr[i]);
		temp.remove(temp.size() - 1);
		
		while(i<n-1 && arr[i] == arr[i+1]) {
			i++;
		}
		
		findCombinations(arr, i+1, n, temp, sum);
	}
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-- > 0) {
		    findCombinationflag = 0;
			
		    int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			
			int sum = sc.nextInt();
			Arrays.sort(arr);
			
			ArrayList<Integer> temp = new ArrayList<>();
			
			findCombinations(arr,0,n, temp, sum);
			
			if(findCombinationflag == 0){
			    System.out.print("Empty");
			}
			
			System.out.println();
		}
		return;
	}

}

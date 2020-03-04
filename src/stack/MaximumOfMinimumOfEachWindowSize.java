package stack;

import java.util.Stack;

public class MaximumOfMinimumOfEachWindowSize {

	public static void findMaxOfMin(int arr[], int n) {
		int leftMinIndex[] = new int[n];
		int rightMinIndex[] = new int[n];
		
		for(int i = 0;i<n;i++) {
			leftMinIndex[i] = -1;
			rightMinIndex[i] = n;
		}
		
		Stack<Integer> s = new Stack<>();
		int i = 0;
		while(i<n) {
			while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
				//leftMinIndex[s.peek()] = i;
				s.pop();
			}
			if(!s.isEmpty()) {
				leftMinIndex[i] = s.peek();
			}
			s.push(i);
			i++;
		}
		
//		for(i = 0;i<n;i++) {
//			System.out.print(leftMinIndex[i] + " ");
//		}
//		System.out.println();
		
		s.clear();
		i = n-1;
		while(i>=0) {
			while(!s.isEmpty() && arr[s.peek()]>=arr[i]) {
				//rightMinIndex[s.peek()] = i;
				s.pop();
			}
			if(!s.isEmpty()) {
				rightMinIndex[i] = s.peek();
			}
			s.push(i);
			i--;
		}
		
//		for(i = 0;i<n;i++) {
//			System.out.print(rightMinIndex[i] + " ");
//		}
		
		int ans[] = new int[n+1];
		
		for(i = 0;i<n;i++) {
			int length = rightMinIndex[i] - leftMinIndex[i] - 1;
			
			ans[length] = Math.max(ans[length], arr[i]);
		}
		
		for(i=n-1;i>=0;i--) {
			ans[i] = Math.max(ans[i], ans[i+1]);
		}
		for(i = 1;i<=n;i++) {
			System.out.print(ans[i]+" ");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 20, 30, 50, 10, 70, 30};
		int len = arr.length;
		
		findMaxOfMin(arr, len);

	}

}

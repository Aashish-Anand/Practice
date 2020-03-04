package chefTeCode;

import java.util.Stack;

public class CDUTSV02 {

	public static void main(String[] args) {
		int arr[] = {5,1,3,2,4};
		
		Stack<Integer> s = new Stack<>();
		
		int len = arr.length;
		
		int value = 1;
		int j = 0;
		int count=0;
		
		while(j<len) {
			if(arr[j] == value) {
				count++;
				value++;
				j++;
			}else if(!s.isEmpty() && value == s.peek()) {
				count++;
				s.pop();
				value++;
			}
			else {
				s.push(arr[j]);
				j++;
			}
		}
		
		while(!s.isEmpty()) {
			if(s.peek() == value) {
				s.pop();
				value++;
				count++;
			}
			else {
				System.out.println("NO");
			}
		}
		if(count == len) {
			System.out.println("Yes");
		}
		//System.out.println("No");
	}

}

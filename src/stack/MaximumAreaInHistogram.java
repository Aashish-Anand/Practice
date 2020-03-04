package stack;

import java.util.Arrays;
import java.util.Stack;

public class MaximumAreaInHistogram {

	public static int findMaxArea(int hist[], int size) {
		
		int leftMin[]= new int[size];
		int rightMin[] = new int[size];
		Arrays.fill(leftMin,-1);
		Arrays.fill(rightMin,size);
		
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);  // pushing the zeroth index
		int i =1;
		
		while(!stack.isEmpty() && i<size) {
			int index = stack.peek();
			while(!stack.isEmpty() && hist[i]<hist[index]) {
				rightMin[index] = i;  // populating the index of nearest smalled element on the right
				stack.pop();
				if(!stack.isEmpty()) {
					index = stack.peek();
				}
			}
			stack.push(i);
			i++;
		}
		for(int a : rightMin) {
			System.out.print(a + " ");
		}
		
		stack.clear();
		stack.push(size-1);
		i = size-2;
		
		while(!stack.isEmpty() && i>=0) {
			int index = stack.peek();
			while(!stack.isEmpty() && hist[index] > hist[i]) {
				leftMin[index] = i;
				stack.pop();
				if(!stack.isEmpty()) {
					index = stack.peek();
				}
			}
			stack.push(i);
			i--;
		}
		
		int maxarea = 0;
		for(int j = 0;j<size;j++) {
			
			int area = (Math.abs(leftMin[j]-rightMin[j]) - 1) * hist[j];
			
			if(area > maxarea) {
				maxarea = area;
			}
		}
		
		return maxarea;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hist[] = {6,2,5,4,5,1,6};
		int size = hist.length;
		System.out.println(findMaxArea(hist,size));
	}

}

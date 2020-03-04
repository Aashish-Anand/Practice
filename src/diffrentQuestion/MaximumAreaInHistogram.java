package diffrentQuestion;

import java.util.Arrays;
import java.util.Stack;

public class MaximumAreaInHistogram {

	public static int findMaxArea(int hist[], int len) {
		int leftMin[] = new int[len];
		int rightMin[] = new int[len];
		Arrays.fill(leftMin, -1);
		Arrays.fill(rightMin, 7);
		
		Stack<Integer> s = new Stack<>();
		
		/*
		 * First we are populating the right min
		 */
		s.push(0);
		int i = 1;
		while(!s.isEmpty() && i< len) {
			int index = s.peek();
			while(!s.isEmpty() && hist[index] > hist[i]) {
				rightMin[index] = i;
				s.pop();
				if(!s.isEmpty()) {
					index = s.peek();
				}
			}
			s.add(i);
			i++;
		}
		for(int a: rightMin) {
			System.out.print(a +" ");
		}
		
		System.out.println();
		/*
		 * left min
		 */
		s.clear();
		s.push(len-1);
		i = len-2;
		
		while(!s.isEmpty() && i>=0) {
			int index = s.peek();
			while(!s.isEmpty() && hist[i] < hist[index]) {
				leftMin[index] = i;
				s.pop();
				if(!s.isEmpty()) {
					index = s.peek();
				}
			}
			s.add(i);
			i--;
		}
		
		/*
		 * Finding the max area
		 */
		
		int maxArea = 0;
		for(int j = 0;j<len;j++) {
			
			int area = (Math.abs(leftMin[j] - rightMin[j]) - 1) * hist[j];
			if(area > maxArea) {
				maxArea = area;
			}
			
			System.out.print(area + " ");
		}
		

		return maxArea;
	}

	public static void main(String[] args) {

		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };

		int len = hist.length;

		System.out.println(findMaxArea(hist, len));
	}

}

package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {

	public static void stockSpan(int arr[], int n) {
		
		int leftMaxPos[] = new int[n];
		
		Arrays.fill(leftMaxPos, -1);
		
		Stack<Integer> s = new Stack<>();
		s.push(0);
		int i = 1;
		
		while(!s.isEmpty() && i<n) {
			int index = s.peek();
			while(!s.isEmpty() && arr[index] <= arr[i]) {  // check until we didn't find the larger
				s.pop();
				if(!s.isEmpty()) {
					index = s.peek();
				}
			}
			if(!s.isEmpty()) {
				leftMaxPos[i] = index;
			}
			s.push(i);
			i++;
		}
		
		for(int j=0;j<n;j++) {
			System.out.print(j-leftMaxPos[j] + " ");
		}
		
	}
	
	public static void main(String[] args) {
		//int arr[] = {100,80,60,70,60,75,85};
		int arr[] = {74,665,742,512,254,469,748,445,663,758,38,60,724,142,330,779,317,636,591,243,289,507,241,143,65,249,247,606,691,330,371,151,607,702,394,349,430,624,85,755,357,641,167,177,332,709,145,440,627,124,738,739,119,483,530,542,34,716,640,59,305,331,378,707,474,787,222,746,525,673,671,230,378,374,298,513,787,491,362,237,756,768,456,375,32,53,151,351,142,125,367,231,708,592,408,138,258,288,554,784,546,110,210,159,222,189,23,147,307,231,414,369,101,592,363,56,611,760,425,538,749,84,396,42,403,351,692,437,575,621,597,22,149,800};
		int n = arr.length;
		
		stockSpan(arr,n);
	}

}

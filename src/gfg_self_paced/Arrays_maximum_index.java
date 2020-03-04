package gfg_self_paced;

public class Arrays_maximum_index {

	public static void main(String[] args) {
		
		int arr[] = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		int len = arr.length;
		
		int first = 0;
		int last = len -1;
		int max = -1;
		
		while(last - first > max) {
			int i = first;
			int j = last;
			
			while(arr[j] < arr[i] && j>i ) {
				j--;
			}
			
			if(arr[j] > arr[i] && j-i > max) {
					max = j-i;
			}
			first++;
		}
		System.out.print(max);

	}

}

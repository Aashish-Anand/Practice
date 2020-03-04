package sorting;

import java.util.Arrays;

public class DutchFlagSorting {

	private static void segregate(int arr[], int len) {
		int low = 0;
		int mid = 0;
		int high = len -1;
		
		while(mid<=high) {
			switch(arr[mid]) {
				case 0: int temp = arr[low];
						arr[low] = arr[mid];
						arr[mid] = temp;
						low++;
						mid++;
						break;
				case 1: mid++; break;
				case 2: temp = arr[high];
						arr[high] = arr[mid];
						arr[mid] = temp;
						high--;
						break;
			}
		}
		Arrays.stream(arr).forEach(e->System.out.print(e+" "));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,2,2,0,1,2,1,0};
		int len = arr.length;
		
		segregate(arr, len);
	}

}

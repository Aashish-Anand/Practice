package backTracking;

import java.util.Arrays;

public class AllPermutations {

	public static void swap(char[] arr, int a, int b) {
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void permute(char[] arr, int l, int r) {
		if (l == r) {
			System.out.println(Arrays.toString(arr));
		} else {
			for (int i = l; i < r; i++) {
				swap(arr, i, l);
				permute(arr, l + 1, r);
				swap(arr, i, l);
			}
		}
	}

	public static void main(String[] args) {

		char[] arr = { 'A', 'B', 'C' };

		permute(arr, 0, arr.length);

	}

}

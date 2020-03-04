package arrays;

/*
 * Input:
	3
	2
	1 0
	5
	4 0 2 1 3
	4
	3 2 0 1

	Output:
	0 1
	3 4 2 0 1
	1 0 3 2
 */
public class RearrangeArrayWithO1ExtraSpace {

	public static void RearrangeElements(int arr[], int n) {
		
		for(int i = 0;i<n;i++) {
			arr[i] = (arr[arr[i]] % n)*n + arr[i];
		}
		
		for(int i = 0;i<n;i++) {
			arr[i] /= n;
		}
		
		for(int i = 0;i<n;i++) {
		System.out.print(arr[i] + " ");
		}
		
	}
	public static void main(String[] args) {
		int arr[] = {4, 0, 2, 1, 3};
		
		RearrangeElements(arr, arr.length);
	}
}

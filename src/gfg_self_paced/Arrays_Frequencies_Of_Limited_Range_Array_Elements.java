package gfg_self_paced;

public class Arrays_Frequencies_Of_Limited_Range_Array_Elements {

	public static void count(int arr[], int n) {
		for(int i = 0;i<n;i++) {
			arr[i] -= 1;
		}
		
		for(int i = 0;i<n;i++) {
			arr[arr[i]%n] += n;
		}
		
		for(int i = 0;i<n;i++) {
			System.out.print(arr[i]/5 +" ");
		}
	}
	public static void main(String[] args) {
		
		int arr[] = {2,3,2,3,5};
		int n = arr.length;
		
		count(arr,n);
	}

}

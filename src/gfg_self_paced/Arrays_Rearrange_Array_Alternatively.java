package gfg_self_paced;

public class Arrays_Rearrange_Array_Alternatively {

	public static void main(String[] args) {
		int arr[] = {10,20,30,40,50,60,70,80,90,100,110};
		
		int n = arr.length;
		
		int i = 0;
		while(i<n-1) {
			int temp = arr[n-1];
			int j = n-1;
			while(j>i) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[i] = temp;
			i+=2;
		}
		for(int a: arr) {
			System.out.print(a+" ");
		}
	}

}

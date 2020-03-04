package gfg_self_paced;

public class Arrays_Rearrange_an_Array_In_O1_Extra_Space {

	public static void main(String[] args) {
		
		int arr[] = {4,0,2,1,3};
		int n = arr.length;
		
		for(int i =0;i<n;i++) {
			arr[i] += (arr[arr[i]]%n) * n;
		}
		
		for(int i = 0;i<n;i++) {
			System.out.println(arr[i]/n);
		}
	}

}

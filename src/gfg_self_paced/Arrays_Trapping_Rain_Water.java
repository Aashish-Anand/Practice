package gfg_self_paced;

public class Arrays_Trapping_Rain_Water {

	public static int findWater(int arr[], int n) {
		
		int waterTrapped = 0;
		
		int leftMax[] = new int[n];
		int rightMax[] = new int[n];
		
		leftMax[0] = -1;
		
		int max = arr[0];
		for(int i = 1;i<n;i++) {
			leftMax[i] = max;
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		max = arr[n-1];
		rightMax[n-1] = -1;
		
		for(int i = n-2;i>=0;i--) {
			rightMax[i] = max;
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		for(int i = 0;i<n;i++) {
			int water = Math.min(leftMax[i], rightMax[i]) - arr[i];
			
			if(water > 0) {
				waterTrapped += water;
			}
		}
		
		
		return waterTrapped;
	}
	public static void main(String[] args) {
		
		int arr[] = {3,1,6,5,2,4};
		int len = arr.length;
		
		System.out.println(findWater(arr,len));
	}

}

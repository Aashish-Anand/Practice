package arrays;

public class Merging2Arrays {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		 int i = 0;
	        int j = 0;
	        int newm = m+n;
	        while(j<n){
	            if(i < newm && nums1[i]<nums2[j]){
	                i++;
	            }
	            else if(i> m && i < newm && nums1[i] == 0 && j<n){
	                nums1[i] = nums2[j];
	                i++;
	                j++;
	            }
	            else{
	                int k = newm-1;
	                while(k>i){
	                    nums1[k] = nums1[k-1];
	                    k--;
	                }
	                nums1[i] = nums2[j]; 
	                j++;
	                i++;
	            }
	        }
	        
	        for(int k =0;k<m;k++) {
	        	System.out.print(nums1[k] + " ");
	        }
	}
	public static void main(String[] args) {
		
		int nums1[] = {1,2,3,0,0,0};
		int nums2[] = {2,5,6};
		
		merge(nums1, 6, nums2, 3);
		
//		int nums1[] = {2,0};
//		int nums2[] = {1};
//		merge(nums1, 2, nums2, 1);
		

	}

}

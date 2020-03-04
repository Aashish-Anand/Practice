package arrays;

/*
 *  input = 10 20 30 40 50 60 70 80
 *  output = 80 10 70 20 60 30 50 40
 */
public class RearrangeArrayElements {

	public static void rearrangeArray(int arr[], int n) {
		
		// Your code here
        int i = 0;
        int last = n-1;
        while(i < n){
            
            int temp = arr[n-1];
            
            int j = n-1;
            while(j>i){
                arr[j] = arr[j-1];
                j--;
            }
            arr[i] = temp;
            i = i+2;
        }
        
        for(int k = 0;k<n;k++) {
            System.out.print(arr[k] + " ");
        }    
        
	}
	
	public static void main(String[] args) {
		int arr[] = {10, 20, 30, 40, 50, 60, 70, 80};
		
		rearrangeArray(arr, arr.length);
	}
}

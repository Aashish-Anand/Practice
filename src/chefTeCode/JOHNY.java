package chefTeCode;

import java.util.Arrays;
import java.util.Scanner;

public class JOHNY {
    public static int FindElement(int arr[], int n, int element) {
        int low = 0;
        int high = n-1;
        
        while(low<high) {
            int mid = (high+low)/2;
            
            if(arr[mid] == element){
                return mid;
            }
            else if(arr[mid]<element){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	    Scanner sc = new Scanner(System.in);
	    int t  = sc.nextInt();
	    
	    while(t-- > 0){
	        int n = sc.nextInt();
	        int arr[] = new int[n];
	        for(int i = 0;i<n;i++){
	            arr[i] = sc.nextInt();
	        }
	       
	        int pos = sc.nextInt();
	        
	        int getElement = arr[pos-1];
	        Arrays.sort(arr);
	        System.out.println(FindElement(arr,n, getElement)+1);
	    }
	}

}

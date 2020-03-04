package arrays;

import java.util.Arrays;

public class NextPermutation {

	public int[] nextPermutation(int[] arr) {
        int len  = arr.length;
        int pos = -1;
        
        for(int i = len-2;i>=0;i--) {
            if(arr[i]<arr[i+1]){
                pos = i;
                break;
            }
        }
        
        if(pos == -1){
            Arrays.sort(arr);
            return arr;
        }
        
        int num = arr[pos];
        int nextmax= Integer.MAX_VALUE;
        int nextIndex = -1;
        
        for(int i = pos+1;i<len;i++){
            if(arr[i]>num && nextmax > arr[i]){
                nextmax = arr[i];
                nextIndex = i;
            }
        }
        
        if(nextIndex != -1) {
            int temp = arr[pos];
            arr[pos] = arr[nextIndex];
            arr[nextIndex] = temp;
        }
        
        Arrays.sort(arr,pos+1,len);
        return arr;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1,2,3,5,6,4};  
		
		NextPermutation n = new NextPermutation();
		
		int abc[] = n.nextPermutation(arr);
		
		System.out.print(Arrays.toString(abc));
	}

}

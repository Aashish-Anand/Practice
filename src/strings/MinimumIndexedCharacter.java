package strings;

import java.util.Arrays;

public class MinimumIndexedCharacter {

	public static void main(String[] args) {

        // Your code here
        
		String s1 = "geeksforgeeks";
		String s2 = "set";
        int arr[] = new int[26];
        Arrays.fill(arr,Integer.MAX_VALUE);
        
        for(int i =0;i<s1.length();i++){
            int num = s1.charAt(i) - 'a';
            
            if(arr[num]>i){
                arr[num] = i;
            }
        }
        
        int minPos = Integer.MAX_VALUE;
        char minIndex='z';
        for(int i = 0;i<s2.length();i++){
            int pos = arr[s2.charAt(i) - 'a'];
            
            if(pos<minPos){
                minPos = pos;
                minIndex = s2.charAt(i);
            }
        }
        if(minPos<Integer.MAX_VALUE){
            System.out.print(minIndex);
        }
        else{
            System.out.println("No character present");
        }
        
    
	}
}

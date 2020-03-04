package arrays;

import java.util.Arrays;

public class MaximumOccuredInteger {

	static int findMaxOccuredInteger(int L[], int R[], int len, int maxxOfR) {
		
		int max[] = new int[maxxOfR+2];
		
		Arrays.fill(max, 0);
		
		for(int i = 0;i<len;i++) {
			max[L[i]]++;
			max[R[i]+1]--;
		}
		int num = max[0];
		int maxOccured = 0;
		int freq = num;
		for(int i = 1;i<maxxOfR;i++) {
			num += max[i];
			
			if(num > freq) {
				freq = num;
				maxOccured = i;
			}
		}
		
		return maxOccured;
		
		
	}
	
	public static void main(String[] args) {
		
		int L[] = {1,4,3,1};
		int R[] = {15,8,5,4};
		
		int max = findMaxOccuredInteger(L,R,L.length, 15);
		System.out.print(max);
	}

}

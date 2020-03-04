package chefTeCode;

import java.util.Arrays;

public class Nukes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = 4;  // number of particle bombarded
		int N = 2;  // threshold value of reactor
		int K = 3;  // number of reactor
		
		int arr[] = new int[K];
		
		Arrays.fill(arr, 0);
		
		int i = 0;
		while(i<A) {
			int j = 0;
			while(j<K) {
				arr[j]++;
				if(arr[j]>N) {
					arr[j] = 0;
					j++;
				}
				else {
					break;
				}
			}
			i++;
		}
		
		for(int a: arr) {
			System.out.println(a);
		}
	}

}

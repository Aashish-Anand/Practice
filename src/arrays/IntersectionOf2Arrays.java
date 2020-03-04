package arrays;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class IntersectionOf2Arrays {

	public static void main(String[] args) {

		int arr1[] = {23,30,42,57,90};
		int arr2[] = {21,23,35,57,90,92};
		
		int size1 = arr1.length;
		int size2 = arr2.length;
		int i = 0;
		int j = 0;
		HashSet<Integer> hash = new HashSet<>();
		while(i<size1 && j<size2) {
			if(arr1[i] == arr2[j]) {
				hash.add(arr1[i]);
				i++;
				j++;
			}
			else if(arr1[i]<arr2[j]){
				i++;
			}
			else {
				j++;
			}
		}
		
		System.out.println(hash.size());
		Iterator itr = hash.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}

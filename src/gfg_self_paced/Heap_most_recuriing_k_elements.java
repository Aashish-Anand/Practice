package gfg_self_paced;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Heap_most_recuriing_k_elements {

	public static void main(String[] args) {
		
		int arr[] = {3,1,4,4,5,2,6,1};
		int len = arr.length;
		
		int num = 2;
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i = 0;i<len;i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}
			else {
				map.put(arr[i], 1);
			}
		}
		
		int count = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(Map.Entry<Integer, Integer> a : map.entrySet()) {
			pq.add(a.getValue());
		}
		
		while(num-->0) {
		    count += pq.poll();
		}
		
		System.out.println(count);
	}

}

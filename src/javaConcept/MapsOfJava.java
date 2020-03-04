package javaConcept;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapsOfJava {

	public static void main(String[] args) {
		Map<String,Integer> hashMap = new HashMap<>();
		Map<String, Integer> linkedHashMap = new LinkedHashMap<> ();
		Map<String, Integer> treeMap = new TreeMap<>();
		
		String arr[] = {"aashish", "anand","shahid","ansari", "mukhtar","ansari", "pony","bobin"};
		
		for(int i = 0;i<arr.length;i++) {
			hashMap.put(arr[i], i);
			linkedHashMap.put(arr[i], i);
			treeMap.put(arr[i], i);
		}
		
		for(Map.Entry<String, Integer> m : hashMap.entrySet()) {
			System.out.println(m.getKey() + " "+ m.getValue());
		}
		
		System.out.println();
		for(Map.Entry<String, Integer> m : linkedHashMap.entrySet()) {
			System.out.println(m.getKey() + " "+ m.getValue());
		}
		
		System.out.println();
		for(Map.Entry<String, Integer> m : treeMap.entrySet()) {
			System.out.println(m.getKey() + " "+ m.getValue());
		}
		
		/*
		 * Now we sorting hashmap using keys 
		 */
		List<Map.Entry<String,Integer>> list = new LinkedList<>(hashMap.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
//				int nameCompare = m1.getKey().compareTo(m2.getKey());
//				int orderCompare = m1.getValue().compareTo(m2.getValue());
//				if(orderCompare == 0){
//					return ((nameCompare==0)?orderCompare:nameCompare);
//				}
//				return orderCompare;
				return m2.getValue().compareTo(m1.getValue());
			}
		});
		System.out.println("After sorting");
		Map<String,Integer> sortedHashMap = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> m : list) {
			sortedHashMap.put(m.getKey(), m.getValue());
			//System.out.println(m.getKey() + " "+ m.getValue());
		}
		
		for(Map.Entry<String, Integer> a : sortedHashMap.entrySet()) {
			System.out.println(a.getKey() + " "+ a.getValue());
		}
		
		
		//reverse sorting
		List<Map.Entry<String, Integer>> ll = new LinkedList<>(linkedHashMap.entrySet());
		Collections.sort(ll, new Comparator<Map.Entry<String, Integer>>() {
			
			@Override
			public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
				return m1.getValue() > m2.getValue()? 1: -1;
			}
			
		});
		
		System.out.println();
		Map<String,Integer> mapSorted = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> m: ll) {
			mapSorted.put(m.getKey(), m.getValue());
		}
		
		for(Map.Entry<String, Integer> m: mapSorted.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}

}

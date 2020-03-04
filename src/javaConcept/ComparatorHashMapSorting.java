package javaConcept;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class ComparatorHashMapSorting {
	public static void main(String args[]) {
		
		HashMap<String, String> name = new HashMap<>();
		
		name.put("aashish", "anand");
		name.put("mukhtar", "ansari");
		name.put("shahid", "ansari");
		name.put("piyush", "giri");
		name.put("robin","tomar");
		name.put("shubham", "sahu");
		name.put("ruchi", "kansal");
		name.put("aakash", "singh");
		
		System.out.println("We are first sorting using keys");
		
		System.out.println("Before Sorting using Keys");
		Set<Entry<String, String>> s = name.entrySet();
		
		for(Entry<String, String> e : s) {
			System.out.println(e.getKey() +" "+ e.getValue());
		}
		
		TreeMap<String, String> tree = new TreeMap<>(name);
		Set<Entry<String, String>> map = tree.entrySet();
		System.out.println("After sorting using keys");
		for(Entry<String, String> e: map) {
			System.out.println(e.getKey() +" "+ e.getValue());
		}
		
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("We will be sorting using Values Now");
		System.out.println("++++++++++++++++++++++++++++++++");
		
		
		List<Entry<String,String>> list = new LinkedList<>(name.entrySet());
		
		Collections.sort(list, new Comparator<Entry<String, String>> () { 
			public int compare(Entry<String, String> e1, Entry<String, String> e2) {
				return e1.getValue().compareTo(e2.getValue());
			}
		});
		
		HashMap<String, String> hash = new LinkedHashMap<>();
		
		for(Entry<String, String> e: list) {
			hash.put(e.getKey(),e.getValue());
		}
		
		for(Entry<String,String> e : hash.entrySet()) {
			System.out.println(e.getKey() +" "+ e.getValue());
		}
	}
}

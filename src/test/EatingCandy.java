package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Company test
 */

class Chocolate {
	int sweetness;
	int bitterness;
	String name;
	
	Chocolate(int s, int b, String str) {
		this.sweetness = s;
		this.bitterness = b;
		this.name = str;
	}
	
	String getName() {
		return this.name;
	}
}

class SortBy implements Comparator<Chocolate>{

	@Override
	public int compare(Chocolate o1, Chocolate o2) {
		if(o1.sweetness == o2.sweetness) {
			if(o1.bitterness == o2.bitterness) {
				return o1.name.compareTo(o2.name);
			}
			else {
				return o1.bitterness - o2.bitterness;  // increasing order 
			}
		}
		else {
			return o2.sweetness - o1.sweetness; // decreasing order
		}
	}
}
public class EatingCandy {

	public static void findOrderOfEating(List<Integer> sweetness, List<Integer> bitterness, List<String> name, List<Integer> query) {
		
		ArrayList<Chocolate> arr = new ArrayList<>();
		for(int i = 0;i<sweetness.size();i++) {
			Chocolate obj = new Chocolate(sweetness.get(i), bitterness.get(i), name.get(i));
			arr.add(obj);
		}
		Collections.sort(arr, new SortBy());
		
		for(int i = 0;i<query.size();i++) {
			System.out.println(arr.get(query.get(i)-1).getName());
		}
		
	}
	public static void main(String[] args) {
		
		List<Integer> sweetness = new ArrayList<Integer>();
		sweetness.add(3);
		sweetness.add(3);
		
		List<Integer> bitterness = new ArrayList<>();
		bitterness.add(3);
		bitterness.add(2);
		
		List<String> name = new ArrayList<>();
		name.add("a");
		name.add("b");
		
		List<Integer> query = new ArrayList<>();
		query.add(1);
		query.add(2);
		
		findOrderOfEating(sweetness,bitterness, name, query);

	}

}

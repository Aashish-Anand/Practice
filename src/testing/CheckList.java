package testing;

import java.util.LinkedList;
import java.util.Queue;

public class CheckList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> arr = new LinkedList<>();
		
		arr.add(1);
		arr.add(2);
		arr.add(3);
		if(arr.contains(1)) {
			arr.remove(1);
		}
		System.out.println(arr.removeFirst());
		for(int a: arr) {
			System.out.println(a);
		}
	}

}

package testing;

import java.util.HashMap;
import java.util.Map;

public class CheckMap {

	public static void main(String[] args) {
		
		Map<Integer,Integer> map = new HashMap<>();
		map.put(1, 123); 
		
		System.out.println(map.containsKey(2));
	
	}
}

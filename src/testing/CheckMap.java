package testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckMap {

	public static void main(String[] args) {
		
		Map<Integer, List<String>> map = new HashMap<>();
		List<String> str = new ArrayList<>();
		str.add("abc");
		str.add("def");
		str.add("fred");

		
		System.out.println(map.containsKey(2));
	
	}
}

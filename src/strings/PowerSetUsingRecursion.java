package strings;

import java.util.ArrayList;
import java.util.List;

public class PowerSetUsingRecursion {

	public static void FindPower(String str, int index, String s, List<String> list) {
		
		if(index == str.length()) {
			list.add(s);
			return;
		}
		Math.ceil(1);
		FindPower(str,index+1, s+str.charAt(index), list);
		FindPower(str,index+1, s, list);
	}
	
	public static void main(String[] args) {
		String str = "abc";
		
		List<String> list = new ArrayList<>();
		
		FindPower(str,0,"",list);
		
		for(String s : list) {
			System.out.print(s + " ");
		}
	}

}

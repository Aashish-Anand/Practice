package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class AllSubSetOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "abc";
		
		ArrayList<Integer> list = new ArrayList<>();
		LinkedHashSet<String> hash = new LinkedHashSet<>();
		
		for(int i = 0;i<s.length();i++) {
			HashSet<Character> set = new HashSet<>();
			
			for(int j = i;j<s.length();j++) {
				String sub = s.substring(i,j+1);
				if(!hash.contains(sub)) {
//					for(int k = 0;k<sub.length();k++) {
//						set.add(sub.charAt(k));
//					}
					hash.add(sub);
				}
				//list.add(set.size());
			}
		}
		
		for(String abc : hash) {
			System.out.println(abc);
		}
	}

}

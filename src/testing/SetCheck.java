package testing;

import java.util.HashSet;

public class SetCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Short> set = new HashSet<>();
		
		for(Short i = 0;i<100;i++) {
			set.add(i);
			set.remove(i-1);
		}
		
		//System.out.print(set.size());
		
		System.out.println((char)('a'+1));
	}

}

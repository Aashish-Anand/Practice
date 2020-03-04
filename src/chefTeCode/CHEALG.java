package chefTeCode;

public class CHEALG {

	public static void main(String[] args) {

		String s = "c";
		
		String str = "";
		
		int count =1;
		str = str+s.charAt(0);
		char character = s.charAt(0);
		for(int i = 1;i<s.length();i++) {
			if(character == s.charAt(i)) {
				count++;
			}
			else {
				str = str + Integer.toString(count);
				character = s.charAt(i);
				str = str + character;
				count = 1;
			}
		}
		str = str + Integer.toString(count);
		System.out.println(str);
	}

}

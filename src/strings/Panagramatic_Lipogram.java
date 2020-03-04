package strings;

public class Panagramatic_Lipogram {

	/* 
    	Category                No of letters unmatched 
    	Pangram                 	   0 
    	Lipogram                      >1 
    	Pangrammatic Lipogram  		   1 
	*/
	
	static String character = "abcdefghijklmnopqrstuvwxyz";
	
	public static boolean found(char character, char[] ch) {
		
		for(int i = 0;i<ch.length;i++) {
			if(ch[i] == character) {
				return true;
			}
		}
		return false;
	}
	public static void panLipoChecker(char[] str) {
		
		int count = 0;
		
		for(int i = 0;i<str.length ; i++) {
			str[i] = Character.toLowerCase(str[i]);
		}
		
		for(int i = 0;i<26;i++) {
			if(!found(character.charAt(i), str)) {
				count++;
			}
		}
		
		if(count == 0) {
			System.out.println("Panagram");
		}
		else if(count > 1) {
			System.out.println("Lipogram");
		}
		else {
			System.out.println("Panagramatic LipoGram");
		}
		
		
		
		
	}
	public static void main(String[] args) {
		
		char[] str = "The quick brown fox jumped over the lazy dog".toCharArray();
		panLipoChecker(str);
		
		char[] str1 = "The quick brown fox jumps over the lazy dog".toCharArray();
		panLipoChecker(str1);
		
		char[] str2 = "The quick brown fox jum over the lazy dog".toCharArray();
		panLipoChecker(str2);
		
		
	}

}

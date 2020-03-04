package strings;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		
		String[] str = {"flower","flow","float"};
		
		int length = str.length;
		
		String prefix = str[0];
		
		for(int i = 1;i<length;i++) {
			
			while(str[i].indexOf(prefix)!=0) {
				prefix = prefix.substring(0, prefix.length()-1);
				if(prefix.isEmpty()) {
					return;
				}
			}
		}
		System.out.println(prefix);
			
	}

}

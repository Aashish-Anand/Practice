package strings;

public class SubStr {

	public static void main(String[] args) {
		
		String first= "mississippi";
		String second = "issip";
		
		int len1 = first.length();
		int len2 = second.length();
		int j = 0;
		for(int i=0;i<len1;i++) {
			int k = i;
			while(k<len1 && j<len2 && first.charAt(k) == second.charAt(j)) {
				if(j == len2-1) {
					System.out.println(k - len2 +1);
				}
				j++;
				k++;
			}
			j=0;
		}
		System.out.println("NO");
	}

}

package dP;

public class LongestCommonSubsequence_part2 {

	public static void main(String[] args) {

		String first = "aaaaa";
		String second = "aaaabbbaa";
		int len1 = first.length();
		int len2 = second.length();
		
		if(len1>len2) {
			System.out.println("NO");
		}
		else {
			int i = 0;
			int j = 0;
			while(i<len1 && j<len2) {
				if(first.charAt(i) == second.charAt(j)) {
					i++;
				}
				j++;
			}
			System.out.println(i == len1 ? "YES":"NO");
		}

	}

}

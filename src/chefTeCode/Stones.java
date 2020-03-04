package chefTeCode;

public class Stones {

	public static void main(String[] args) {
		
		String first = "aAZ";
		String second = "abcdAZ";
		
		int charArray[] = new int[26];
        int charArrayBig[] = new int[26];
        //Arrays.fill(charArray,0);
	
		for(int i = 0;i<second.length();i++) {
		    if(second.charAt(i) >='A' && second.charAt(i)<='Z'){
		        charArrayBig[second.charAt(i) - 'A']++;
		    }else{
			    charArray[second.charAt(i) - 'a']++;
		    }
		}
		
		int count = 0;
		for(int i = 0;i<first.length();i++) {
		    if(first.charAt(i) >='A' && first.charAt(i)<='Z'){
		        if(charArrayBig[first.charAt(i) - 'A'] > 0) {
				    charArrayBig[first.charAt(i) - 'A']--;
			    	count++;
		    	}
		    }
		    else{
		        if(charArray[first.charAt(i) - 'a'] > 0) {
				    charArray[first.charAt(i) - 'a']--;
			    	count++;
		    	}
		    }
			
		}
		System.out.println(count);
	}

}

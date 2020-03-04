package chefTeCode;

public class DISCSHOP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * 		Some TestCases are not passed with this solution
 

 * 		int n = 998;
	    String s = Integer.toString(n);
	    char[] arr = s.toCharArray();
	    int size = arr.length-1;
	    int max = Integer.MIN_VALUE;
	    int maxpos = -1;
	    while(size>=0) {
	    	int currNumber = arr[size] - '0';
	    	if(currNumber > max) {
	    		max = currNumber;
	    		maxpos = size;
	    	}
	    	else if(currNumber == 0) {
	    		maxpos =  -1;
	    		max = Integer.MIN_VALUE;
	    	}
	    	size--;
	    }
	    //System.out.println(max + " " + maxpos);
	    String result = "";
	    for(int i = 0;i<arr.length;i++) {
	    	if(i!=maxpos) {
	    		//System.out.print(arr[i]+" ");
	    		result += arr[i];
	    	}
	    }
	    System.out.println(Integer.valueOf(result));
*/	
		
		/*
		 * This solution passed all the testCases
		 */
		int n = 100043;
		String s = Integer.toString(n);
		int minimumValue = 100043;
		for(int i = 0;i<s.length();i++) {
			StringBuffer str = new StringBuffer(s);
			str.deleteCharAt(i);
			int number = Integer.parseInt(str.toString());
			if(number < minimumValue) {
				minimumValue = number;
			}
		}
		
		System.out.println(minimumValue);
		
	}
}

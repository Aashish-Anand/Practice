package arrays;

public class Find2RepeatedNumber {

	public static void print2Numbers(int a[], int n) {
		
		int xor = a[0];
		
		for(int i = 1;i<a.length;i++) {
			xor ^= a[i];
		}
		//System.out.println(xor);
		for(int i = 1;i<=n;i++) {
			xor ^= i;
		}
		//System.out.println(xor);
		
		int right_most_bit = xor & ~(xor-1);
		//System.out.println(right_most_bit);
		
		int X = 0;
		int Y = 0;
		
		for(int i = 0;i<a.length;i++) {
			if((a[i] & right_most_bit) !=  0) {
				X = X ^ a[i];
			}
			else {
				Y = Y ^ a[i];
			}
		}
		for(int i = 1;i<=n;i++) {
			if((i & right_most_bit) !=  0) {
				X = X ^ i;
			}
			else {
				Y = Y ^ i;
			}
		}
		System.out.print(X + " " + Y); 
	}
	
	public static void main(String[] args) {
		
		int a[] = {1,2,3,1,2,4};
		int n = 4;
		String abc = "abcde";
		System.out.println(abc.substring(0,abc.length()-1));
		print2Numbers(a,n);
	}

}

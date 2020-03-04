package chefTeCode;

public class CIELAB {

	public static void main(String[] args) {

		// your code goes here
		int a = 2000;
		int b = 1000;

		int diff = a - b;

		int digits = (int) Math.log10(diff) + 1;

		int diff1 = diff - 1;
		int diff2 = diff + 1;

		int digits1 = (int) Math.log10(diff1) + 1;
		int digits2 = (int) Math.log10(diff2) + 1;

		if (digits == digits1) {
			System.out.println(diff1);
		} else {
			System.out.println(diff2);
		}

	}

}

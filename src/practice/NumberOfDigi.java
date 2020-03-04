package practice;

public class NumberOfDigi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 109756;
		int digits = (int) Math.floor(Math.log10(n))+1;
		//System.out.println((int) Math.floor(Math.log10(n))+1);
		
		int i = digits/2;
		int firstSum = 0;
		while(i>0) {
			firstSum += n%10;
			n /= 10;
			i--;
		}
		int secondSum = 0;
		while(n>0) {
			secondSum += n%10;
			n /= 10;
		}
		System.out.println(firstSum + " " + secondSum);
		
	}

}

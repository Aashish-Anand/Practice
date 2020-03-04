package diffrentQuestion;

public class ZeroesInFactorials {

	public static void main(String[] args) {
		
		int n = 8735373;
		int i = 1;
		int count = 0;
		while(n>0) {
			count += n/5;
			i++;
			n = n/5;
		}
		System.out.println(count);
		System.out.println((int)(Math.log10(19999))+1);
	}

}

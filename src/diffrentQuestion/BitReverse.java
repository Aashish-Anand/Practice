package diffrentQuestion;

public class BitReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		long n = 3;
//		System.out.println(1<<n);
//		
		//reverse the bits
		long num = 1;
        long i = 0;
        while(i<32){
            num = num << 1;
            num = num | (n&1);
            n = n>>1;
            i++;
        }
        System.out.println(num);
		
	}

}

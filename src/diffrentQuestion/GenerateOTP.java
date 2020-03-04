package diffrentQuestion;

import java.util.Random;

public class GenerateOTP {
	
	public static char[] OTP(int len) {
		String number = "0123456789";
		
		Random ran = new Random();
		
		char[] otp = new char[4];
		
		for(int i = 0;i<4;i++) {
			otp[i] = number.charAt(ran.nextInt(number.length()));
		}
		return otp;
	}

	public static void main(String[] args) {
		
		int length = 4;
		System.out.println(OTP(length));
	}

}

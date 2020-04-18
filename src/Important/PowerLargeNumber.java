package Important;

import java.util.Scanner;

public class PowerLargeNumber {
    public static void main(String[] args) {
        new PowerLargeNumber().run();
    }

    long MOD = 1000000007;
    private void run() {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        System.out.println(findPower(a,b));
    }

    private long findPower(String a, String b) {

        long first = 0;
        long second = 0;
        for(int i = 0;i<a.length();i++) {
            first = (first*10 + (a.charAt(i) - '0'))%MOD;
        }

        for(int i = 0;i<b.length();i++) {
            second = (second*10 + (b.charAt(i)-'0'))%(MOD);
        }

        return letsPowerItUp(first, second);
    }
    private long letsPowerItUp(long first, long second) {

        long result = 1;
        while(second > 0) {
            if (second % 2 == 1)
            {
                result = result * first % MOD;
            }
            first = (first * first)%MOD;
            second = second/2;
        }
        return result;
    }
}

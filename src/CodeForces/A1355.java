package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1355 {
    public static void main(String[] args) throws IOException {
        new A1355().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while(t-- > 0) {
            String s[] = reader.readLine().split(" ");
            long n = Long.parseLong(s[0]);
            long k = Long.parseLong(s[1]);
            k--;
            while(k-- > 0) {
                long y = getNum(n);
                if(y == 0){
                    break;
                }
                n += y;
            }
            System.out.println(n);
        }
    }

    private long getNum(long n) {

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        while(n>0){
            long digit = n%10;
            n/=10;
            min = Math.min(digit, min);
            max = Math.max(digit, max);
        }
        return min*max;
    }
}

package gfg_interview_prep;

import java.util.Scanner;

public class LargestPrimeFactor {
    public static void main(String[] args) {
        new LargestPrimeFactor().run();
    }
    private void run() {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            long n = sc.nextLong();

            long maxPrime = 0;
            while(n%2==0) {
                n = n/2;
                maxPrime = 2;
            }

            for(long i = 3;i<=Math.sqrt(n);i+=2) {
                    while (n % i == 0) {
                        n = n / i;
                        maxPrime = i;
                    }
            }

            if(n>maxPrime) {
                maxPrime = n;
            }
            System.out.println(maxPrime);

        }
    }

}

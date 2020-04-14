package chefTeCode;

import java.util.Scanner;

public class MOTU001 {
    public static void main(String[] args) {
        new MOTU001().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        long t = sc.nextLong();

        while(t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();

            long quotient = (c-b)/a;

            System.out.println(quotient*a + b);

        }
    }
}

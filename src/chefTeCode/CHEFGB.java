package chefTeCode;

import java.util.Scanner;
/*
Very Important question
 */
public class CHEFGB {
    public static void main(String[] args) {
        new CHEFGB().run();
    }
    static long MOD = (long) (1e9 + 7);
    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            long n = sc.nextLong();

            System.out.println(powerStrings(Long.toString(2),Long.toString(n)) - 1);

        }
    }

    long powerStrings(String sa, String sb)
    {
        long a = 0, b = 0;

        for (int i = 0; i < sa.length(); i++)
        {
            a = (a * 10 + (sa.charAt(i) - '0')) %
                    MOD;
        }

        for (int i = 0; i < sb.length(); i++)
        {
            b = (b * 10 + (sb.charAt(i) - '0')) %
                    (MOD - 1);
        }
        return powerLL(a, b);
    }
    long powerLL(long x, long n)
    {
        long result = 1;
        while (n > 0)
        {
            if (n % 2 == 1)
            {
                result = result * x % MOD;
            }
            n = n / 2;
            x = x * x % MOD;
        }
        return result;
    }
}

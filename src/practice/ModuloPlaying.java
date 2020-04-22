package practice;

import java.util.Scanner;

/**
 * http://theoryofprogramming.com/2014/12/24/modular-arithmetic-properties/
 *
 * need to solve (x! + y!)mod10^9 + 7
 */
public class ModuloPlaying {

    public static void main(String[] args) {
        new ModuloPlaying().run();
    }

    final int MOD = 1000000007;

    private void run() {
        Scanner sc = new Scanner(System.in) ;

        int x = sc.nextInt();
        int y = sc.nextInt();

        long productX = 1;
        for(int i = 1;i<=x;i++) {
            productX = ((productX % MOD) * (i%MOD))%MOD ;
        }
        System.out.println(productX);

        long productY = 1;
        for(int i = 1;i<=y;i++) {
            productY = ((productY%MOD) * (i%MOD)) % MOD;
        }

        System.out.println(productY);
        System.out.println(((productX%MOD) + (productY%MOD))%MOD);

        sc.close();
    }
}

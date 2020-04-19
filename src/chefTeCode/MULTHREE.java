package chefTeCode;

import java.util.Scanner;

/*
Not completed
 */
public class MULTHREE {
    public static void main(String[] args) {
        new MULTHREE().run();
    }
    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-->0) {
            long k = sc.nextLong();
            int d0 = sc.nextInt();
            int d1 = sc.nextInt();
            long sum = d0+d1;

            for(int i = 0;i<k-2;i++) {
                long newNum = sum%10;
                sum+= newNum;
            }
            System.out.println(sum%3==0?"YES":"NO");

        }
    }
}

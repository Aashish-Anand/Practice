package chefTeCode;

import java.util.Scanner;

public class BBALLS {
    public static void main(String[] args) {
        new BBALLS().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t= sc.nextInt();

        while(t-- > 0) {
            long n = sc.nextLong();
            long count = 0;
            while(n>0) {
                n = n&(n-1);
                System.out.println(n);
                count++;
            }
            System.out.println(count-1);
        }
    }
}

package CodeForces;

import java.util.Scanner;

public class C642 {
    public static void main(String[] args) {
        new C642().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-->0) {
            long n = sc.nextLong();

            long num = (n-1)/2;


            System.out.println((8*(num * (num+1) * ((2*num) +1)))/6);
        }
    }
}

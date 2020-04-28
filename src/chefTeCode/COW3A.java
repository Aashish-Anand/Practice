package chefTeCode;

import java.util.Scanner;

public class COW3A {
    public static void main(String[] args) {
        new COW3A().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int T = sc.nextInt();

            int a, m,o;

            o = T - A;
            m = B - o;
            a = C - o;
            System.out.println(a +" " +m+" "+ o);
        }
    }
}

package chefTeCode;

import java.util.Scanner;

public class LIFTME {
    public static void main(String[] args) {
        new LIFTME().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int N = sc.nextInt();
            int req = sc.nextInt();
            long distance = 0;
            long initial = 0;
            for(int i = 0;i<req;i++) {
                long first = sc.nextLong();
                long second = sc.nextLong();

                distance += Math.abs(initial - first);
                distance += Math.abs(second - first);
                initial = second;
            }

            System.out.println(distance);
        }
    }
}

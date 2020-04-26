package chefTeCode;

import java.util.Scanner;

public class ECAPR202 {
    public static void main(String[] args) {
        new ECAPR202().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-->0) {
            long radius = sc.nextLong();
            long diameter = 2*radius;

            System.out.println((diameter*diameter)/2);

        }
    }
}

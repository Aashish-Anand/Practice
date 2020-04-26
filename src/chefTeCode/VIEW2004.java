package chefTeCode;

import java.text.DecimalFormat;
import java.util.Scanner;

public class VIEW2004 {
    public static void main(String[] args) {
        new VIEW2004().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            Double number = sc.nextDouble();
            int power = sc.nextInt();
            DecimalFormat format = new DecimalFormat("0.##");

            System.out.println(format.format(number * Math.pow(10, power)));
        }
    }
}

package chefTeCode;

import java.util.Scanner;

public class FCTRL {
    public static void main(String[] args) {
        new FCTRL().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0) {
            int n = sc.nextInt();

            int i = 1;
            int count = 0;
            while(true) {
                int num = (int)Math.pow(5,i);
                if(num > n) {
                    break;
                }
                count += n/num;
                i++;
            }
            System.out.println(count);

        }
    }
}

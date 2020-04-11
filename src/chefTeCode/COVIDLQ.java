package chefTeCode;

import java.util.Scanner;

public class COVIDLQ {
    public static void main(String[] args) {
        new COVIDLQ().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int num = 0;
            boolean firstOne = false;
            int pos = -1;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                num = sc.nextInt();
                if(num == 1 && !firstOne){
                    pos = i;
                    firstOne = true;
                }else if(num==1 && (i - pos<6)) {
                    flag = false;
                    pos = i;
                }else if(num==1) {
                    pos = i;
                }
            }
            System.out.println(flag?"YES":"NO");

        }
    }
}

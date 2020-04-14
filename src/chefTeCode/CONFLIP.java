package chefTeCode;

import java.util.Arrays;
import java.util.Scanner;

public class CONFLIP {
    public static void main(String[] args) {
        new CONFLIP().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0) {
            int games = sc.nextInt();
            while(games-- > 0) {
                int i = sc.nextInt();
                int g = sc.nextInt();
                int q = sc.nextInt();


                if(g%2 == 0){
                    System.out.println(g/2);
                }
                else{
                    int half = g/2;
                    half+= 1;
                    if(i == 1){
                        if(q==1) {
                            System.out.println(g-half);
                        }
                        else{
                            System.out.println(half);
                        }
                    }else{
                        if(q==2) {
                            System.out.println(g-half);
                        }
                        else{
                            System.out.println(half);
                        }
                    }
                }

            }
        }
    }
}

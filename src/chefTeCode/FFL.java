package chefTeCode;

import java.util.Scanner;

public class FFL {
    public static void main(String[] args) {
        new FFL().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            int amount = sc.nextInt();

            int price[] = new int[n];
            int type[] = new int[n];

            for(int i = 0;i<n;i++) {
                price[i] = sc.nextInt();
            }
            for(int i = 0;i<n;i++) {
                type[i] = sc.nextInt();
            }

            int cheapestForward = 500;
            int cheapestDefende = 500;

            for(int i =0;i<n;i++) {
                if(type[i]==0){
                    if(price[i]<cheapestDefende) {
                        cheapestDefende = price[i];
                        System.out.println("Defender : "+ cheapestDefende);
                    }
                }
                else if(type[i] ==1) {
                    if(price[i] < cheapestForward) {
                        cheapestForward = price[i];
                        System.out.println("Forward : "+ cheapestForward);
                    }
                }
            }

            if(100<cheapestDefende+cheapestForward+amount) {
                System.out.println("no");
            }
            else{
                System.out.println("yes");
            }

        }
    }
}

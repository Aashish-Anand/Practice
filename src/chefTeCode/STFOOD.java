package chefTeCode;

import java.util.Scanner;

public class STFOOD {
    public static void main(String[] args) {
        new STFOOD().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            long maxprofit = 0;
            for(int i = 0;i<n;i++) {
                int s = sc.nextInt(); // stores
                int p = sc.nextInt(); // people
                int v = sc.nextInt(); // prices

                int peoplecometochef = (int) Math.floor(p/(s+1));

                //System.out.println(peoplecometochef);
                long profit = peoplecometochef * v;

                //System.out.println(profit);
                if(profit > maxprofit) {
                    maxprofit = profit;
                }
            }
            System.out.println(maxprofit);
        }
    }
}

package chefTeCode;

import java.util.Scanner;

public class COVID19 {
    public static void main(String[] args) {
        new COVID19().run();
    }
    private void run() {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            int arr[] = new int[n];
            for(int i = 0;i<n;i++) {
                arr[i] = sc.nextInt();
            }

            int best = Integer.MAX_VALUE;
            int worst = Integer.MIN_VALUE;

            int count = 1;

            for(int i = 0;i<n-1;i++) {
                int j = i+1;
                if(arr[j]-arr[i]<=2) {
                    count++;
                }
                else{
                    if(best > count){
                        best = count;
                    }
                    if(worst<count) {
                        worst = count;
                    }
                    count = 1;
                }
            }

            if(best > count){
                best = count;
            }
            if(worst<count) {
                worst = count;
            }
            System.out.println(best + " " + worst);

        }
    }
}

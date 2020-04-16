package chefTeCode;

import java.util.Scanner;

public class STUPMACH2 {
    public static void main(String[] args) {
        new STUPMACH2().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int min = Integer.MAX_VALUE;
            long sum = 0;
            for(int i = 0;i<n;i++) {
                int num = sc.nextInt();

                if(num < min){
                    sum+=num;
                    min = num;
                }
                else{
                    sum += min;
                }
            }
            System.out.println(sum);
        }
    }
}

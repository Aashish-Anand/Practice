package gfg_interview_prep;

import java.util.Scanner;

public class pairPrime {
    public static void main(String[] args) {
        new pairPrime().run();
    }

    private void run() {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {

            int n = sc.nextInt();

            int arr[] = new int[n];
            int nprime= 0 ;

            for(int i = 2;i<n;i++) {
                if(isPrime(i)) {
                    arr[nprime++] = i;
                }
            }
            boolean flag = true;

            for(int i = 0;i<nprime;i++) {
                for(int j = 0;j<nprime;j++) {
                    if(arr[i]*arr[j] >n) {
                        flag = false;
                        break;

                    }
                    else{
                        System.out.print(arr[i]+" " +arr[j] +" ");
                    }
                }
            }
            System.out.println();
        }
    }

    private boolean isPrime(int num) {

        for(int i = 2;i<=Math.sqrt(num);i++)
        {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
}

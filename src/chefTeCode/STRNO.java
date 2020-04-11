package chefTeCode;

import java.util.Scanner;

public class STRNO {
    public static void main(String[] args) {
        new STRNO().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int arr[] = new int[32768];

            for (int i = 1; i < 32768; i++) {
                arr = new int[32768];

                for (int j = 1; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        arr[j] = 1;
                    }
                }

                int countDiv = 0;
                int countPrime = 0;
                for (int j = 2; j <= i / 2; j++) {
                    if (arr[j] == 1) {
                        countDiv++;

                        boolean flag = true;
                        for (int k = 2; k <= Math.sqrt(j); k++) {
                            if (j % k == 0) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            countPrime++;
                        }
                    }
                }
                countDiv+=1;

                countDiv = i%2==0 ? countDiv*2-1:countDiv*2;
//                if(i == 36){
//                    System.out.println(countDiv);
//                }
                if (n == countDiv && s == countPrime) {
                    System.out.print(i);
                    //System.out.print(countDiv + " " + countPrime);
                    break;
                }
            }
        }
    }
}

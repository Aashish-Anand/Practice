package chefTeCode;

import java.util.Scanner;

public class PSHOT {
    public static void main(String[] args) {
        new PSHOT().run1();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            String str = sc.next();

            int countA = 0;
            int countB = 0;
            int pos = -1;
            for(int i = 1;i<=str.length();i++) {
                int a = 0;
                int b = 0;
                if(str.charAt(i-1)-'0'==1){
                    if(i%2==1) {
                        a = 1;
                    } else {
                        b = 1;
                    }
                }
                if (a == 1) {
                    countA++;
                }
                if (b == 1) {
                    countB++;
                }

                if(i%2==0) {
                    if ((countB - countA) >= (n - (i / 2))  || (countA - countB) > (n - (i / 2))) {
                        pos = i;
                        break;
                    }
                }
            }
            System.out.println(pos);
        }
    }

    //second solution --correct one
    private void run1() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            String str = sc.next();

            int winA = 0;
            int winB = 0;
            int losA = 0;
            int losB = 0;
            int pos = -1;
            for(int i = 0;i<str.length();i++) {
                int num = str.charAt(i)-'0';
                if(i%2 == 0){
                    if(num == 1){
                        winA++;
                    }
                    else{
                        losA++;
                    }
                }
                else{
                    if(num == 1){
                        winB++;
                    }
                    else{
                        losB++;
                    }
                }

                if(winA+losB>n || winB+losA>n) {
                    pos = i+1;
                    break;
                }
            }
            if(pos == -1){
                System.out.println(2*n);
            }
            else{
                System.out.println(pos);
            }
        }
    }
}

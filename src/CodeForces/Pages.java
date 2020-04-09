package CodeForces;

import java.util.Scanner;

/*
https://codeforces.com/problemset/problem/399/A
 */
public class Pages {
    public static void main(String[] args) {
        new Pages().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int d = sc.nextInt();

        if(p-d >1){
            System.out.print("<< ");
            int i = p-d;
            while(i<p){
                System.out.print(i+" ");
                i++;
            }
        }else if(p-d <= 1){
            int i = 1;
            while(i<p) {
                System.out.print(i+" ");
                i++;
            }
        }
        System.out.print("("+p+") ");

        if(p+d < n){
            int i = p+1;
            while(i<=p+d) {
                System.out.print(i+" ");
                i++;
            }
            System.out.print(">>");
        }
        else if(p+d >= n){
            int i = p+1;
            while(i<=n){
                System.out.print(i+" ");
                i++;
            }
        }


    }
}

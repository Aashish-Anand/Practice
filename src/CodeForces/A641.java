package CodeForces;

import java.util.Scanner;

public class A641 {
    public static void main(String[] args) {
        new A641().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            System.out.println(f(n,k));
        }
    }

    private int f(int n, int k){

        if(n%2==0){
            return n+2*k;
        }

        for(int i = 3;i<=n;i++) {
            if(n%i==0){
                return (n+i+(2*(k-1)));
            }
        }
        return n;
    }
}

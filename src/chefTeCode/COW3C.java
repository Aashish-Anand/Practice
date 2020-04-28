package chefTeCode;

import java.util.Arrays;
import java.util.Scanner;

public class COW3C {
    public static void main(String[] args) {
        new COW3C().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int x[] = new int[n];
        int y[] = new int[n];

        for(int i = 0;i<n;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            x[i] = a;
            y[i] = b;
        }

        Arrays.sort(x);
        Arrays.sort(y);

        int i= x[0];
        long count = 1;
        int indexA = 0;
        int indexB = 0;
        long sum = 0;
        while(i<= y[y.length-1]) {
            while(indexA<n && i == x[indexA]) {
                indexA++;
            }
            count = (indexA -indexB)%1000000007;
            while(indexB<n && i == y[indexB]) {
                indexB++;
            }
            //System.out.println(indexA +" "+ indexB);
            sum= (sum +count)%1000000007;
            i++;
        }

        System.out.println(sum);



    }
}

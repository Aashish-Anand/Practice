package chefTeCode;

import java.util.Arrays;
import java.util.Scanner;

public class COW3B {
    public static void main(String[] args) {
        new COW3B().run();
    }
    private void run() {
        Scanner sc= new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0){

            int n = sc.nextInt();
            int A[] = new int[n];

            for(int i =0;i<n;i++) {
                A[i] = sc.nextInt();
            }

            int m = sc.nextInt();
            int B[] = new int[m];

            for(int i = 0;i<m;i++) {
                B[i] = sc.nextInt();
            }
            Arrays.sort(B);

            int count = 0;
            int actualCount = 0;
            for(int i = 0;i<n;i++) {
                int num = A[i];
                int pos = Arrays.binarySearch(B, num);
                if(pos >= 0 &&  pos <=m) {
                    count++;
                }
                else{
                    if(count>0) {
                        actualCount++;
                        count = 0;
                    }
                }
            }
            if(count>0) {
                actualCount++;
            }
            System.out.println(actualCount);
        }
    }
}

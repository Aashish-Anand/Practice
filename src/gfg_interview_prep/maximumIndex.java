package gfg_interview_prep;

import java.util.Scanner;

public class maximumIndex {
    public static void main(String[] args) {
        new maximumIndex().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();

            long arr[] = new long[n];

            for(int i = 0;i<n;i++) {
                arr[i] = sc.nextLong();
            }

            long leftMin[] = new long[n];
            long rightMax[] = new long[n];

            leftMin[0] = arr[0];
            for(int i = 1;i<n;i++) {
                leftMin[i] = Math.min(leftMin[i-1],arr[i]);
            }

            rightMax[n-1] = arr[n-1];

            for(int i = n-2;i>=0;i--) {
                rightMax[i] = Math.max(rightMax[i+1], arr[i]);
            }

            long max = 0;
            int i = 0;
            int j = 1;
            while(i<n) {

                if(j<n && rightMax[j]>leftMin[i]) {
                    max = Math.max(max, j-i);
                    j++;
                }
                else{
                    i++;
                }
            }
            System.out.println(max);
        }
    }
}

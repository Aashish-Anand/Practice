package gfg_interview_prep;

import java.util.Scanner;

public class MaxSubArray {
    public static void main(String[] args) {
        new MaxSubArray().run();
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

            int i = 0;
            int start = -1;
            int end = -1;
            int maxsum = 0;
            int sum = 0;

            while(arr[i]<0) {
                i++;
            }

            int maxStart = 0;
            int maxEnd = 0;

            start = i;
            maxStart = start;
            end = i;
            maxEnd = i;

            sum= arr[start];

            i++;

            while(i<n) {

                if(arr[i]>=0) {
                    sum+= arr[i];
                    end = i;

                }else if(arr[i]<0 && sum >0){

                    if(sum>maxsum) {
                        maxsum = sum;
                        maxEnd = end;
                        maxStart = start;
                    }
                    else if(sum == maxsum) {
                        if(end - start > maxEnd - maxStart) {
                            maxEnd = end;
                            maxStart= start;
                        }
                    }
                    sum = 0;
                    while(i<n && arr[i]<0) {
                        i++;
                    }
                    start = i;
                    end = i;
                    if(i<n) {
                        sum += arr[i];
                    }
                }
                i++;
            }

            if(sum > maxsum) {
                maxStart = start;
                maxEnd = n - 1;
            }

            for(i = maxStart ;i<=maxEnd;i++) {
                System.out.print(arr[i] +" ");
            }
            //System.out.print(start+" " +end);
        }
    }
}

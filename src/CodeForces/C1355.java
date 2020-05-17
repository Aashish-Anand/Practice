package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C1355 {
    public static void main(String[] args) throws IOException {
        new C1355().run1();
    }


    // first approach with n^2 logn // fail for large inputs
    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String []s = reader.readLine().split(" ");

        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);
        int C = Integer.parseInt(s[2]);
        int D = Integer.parseInt(s[3]);

        int arr[] = new int[2*D+1];

        Arrays.fill(arr, 0);
        int i = B;
        int j = C;

        long count = 0;
        while(j>=B){
            i = B;
            while(i>=A) {

                int sum = j+i;
                if(sum < C){
                    break;
                }
                if(arr[sum]==0){
                    arr[sum] = findCount(sum, C, D);
                }

                count += arr[sum];
                i--;
            }
            j--;
        }
        System.out.println(count);
    }

    private int findCount(int sum , int C, int D) {

        int start = C;
        int end = D;
        while(C<=D) {
            int mid = C + (D-C)/2;

            if(mid==end && sum > mid){
                return end - start+1;
            }
            if(sum == mid){
                return mid-start;
            }
            else if(mid < sum){
                C = mid + 1;
            }
            else {
                D = mid -1;
            }
        }
        return 0;
    }



    private void run1() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String []s = reader.readLine().split(" ");

        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);
        int C = Integer.parseInt(s[2]);
        int D = Integer.parseInt(s[3]);


        int z = C;
        long count = 0;
        while(z<=D) {
            int y = B;

            while(B+y <= z && y<z) {
                y++;
            }

            count+= findSum(y, B-A+1);
            count += (C-y)*(B-A+1);
            System.out.print(count);

            break;
        }
    }

    private long findSum(int start, int end) {
        int n = Math.abs(end - start);
        return (n*(n+1))/2;
    }
}

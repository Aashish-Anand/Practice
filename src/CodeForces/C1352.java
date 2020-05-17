package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C1352 {
    public static void main(String[] args) throws IOException {
        new C1352().run();
    }
    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while(t-- > 0){
            String s[] = reader.readLine().split(" ");
            Long n = Long.parseLong(s[0]);
            Long k = Long.parseLong(s[1]);

            Long product = n*k;
            long remainingNumber = product - k;
            long start = 0;
            long end = product;

            while(start<=end) {
                long mid = start +(end-start)/2;

                long nearestPower = (long) (mid/n);

                remainingNumber = mid - nearestPower;

                if(remainingNumber == k && mid%n!=0){
                    System.out.println(mid);
                    break;
                }
                else if (remainingNumber >= k){
                    end = mid-1;
                }
                else {
                    start = mid+1;
                }
            }
        }
    }
}

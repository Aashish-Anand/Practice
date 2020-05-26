package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1358 {
    public static void main(String[] args) throws IOException {
        new B1358().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            String s[] = reader.readLine().split(" ");
            int arr[] = new int[n];
            for(int i =0;i<n;i++) {
                arr[i]=Integer.parseInt(s[i]);
            }

            Arrays.sort(arr);

            long count = 1;

            for(int i = n-1;i>=0;i--) {
                if(arr[i]<= count+i) {
                    count += i+1;
                    break;
                }
            }
            System.out.println(count);
        }
    }
}

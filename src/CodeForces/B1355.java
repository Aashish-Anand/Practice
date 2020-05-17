package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1355 {
    public static void main(String[] args) throws IOException {
        new B1355().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0 ) {
            int n = Integer.parseInt(reader.readLine());
            String s[] = reader.readLine().split(" ");

            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            Arrays.sort(arr);

            System.out.println(findGroups(arr,n));
        }
    }

    private int findGroups(int arr[], int n) {
        int curr = 0;
        int grp = 0;
        int i = 0;
        while(i<n) {
            if(++curr == arr[i]) {
                curr = 0;
                grp += 1;
            }
            i++;
        }
        return grp;
    }
}

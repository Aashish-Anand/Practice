package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1199 {
    public static void main(String[] args) throws IOException {
        new A1199().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s[] = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        int y = Integer.parseInt(s[2]);

        s = new String[n];

        s = reader.readLine().split(" ");

        int arr[] = new int[n];
        for(int i = 0;i<n;i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        for(int i = 0;i<n;i++) {
            int prev = i-1;
            int min = arr[i];
            while(prev >= 0&& prev >= i-x ) {
                if(arr[prev] < min){
                    min = arr[prev];
                    break;
                }
                prev--;
            }
            if(min != arr[i]) {
                continue;
            }
            int next = i+1;
            while(next<n && next<=i+y) {
                if(arr[next]<min) {
                    min = arr[next];
                    break;
                }
                next++;
            }

            if(min != arr[i]) {
                continue;
            }

            if(min == arr[i]) {
                System.out.println(i+1);
                break;
            }
        }
    }
}

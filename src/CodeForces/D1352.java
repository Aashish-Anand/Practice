package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1352 {
    public static void main(String[] args) throws IOException {
        new D1352().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0 ) {
            int n = Integer.parseInt(reader.readLine());
            String s[];

            s = reader.readLine().split(" ");

            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int moves = 0;
            int aliceCount = 0;
            int bobCount = 0;

            int i = 0;
            int j = n-1;
            int lastAlice = 0;
            int lastBob = 0;

            boolean switchEating = true; // true for alice and false for bob
            while(i<=j) {

                while(lastAlice<=lastBob && switchEating && i<=j){
                    aliceCount+=arr[i];
                    lastAlice += arr[i];
                    i++;
                }

                while(lastAlice>=lastBob && !switchEating && i<=j){
                    bobCount+=arr[j];
                    lastBob += arr[j];
                    j--;
                }
                if(switchEating){
                    lastBob = 0;
                }else {
                    lastAlice = 0;
                }
                switchEating = !switchEating;

                moves++;
            }
            System.out.println(moves+" "+aliceCount+" "+bobCount);
        }
    }
}


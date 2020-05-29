package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1359 {
    public static void main(String[] args) throws IOException {
     new A1359().run();
    }

    void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while(t-- > 0) {
            String s[] = reader.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int j = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);

            if(j == 0){
                System.out.println(0);
            }
            else if(n/k >= j) {
                System.out.println(j);
            }
            else{
                int jokerWithPlayer = n/k;
                double remainingJoker = j - jokerWithPlayer;
                int maxJoker = (int)Math.ceil(remainingJoker/(k-1));
                if(maxJoker<=0) {
                    System.out.println(jokerWithPlayer-1);
                }
                else{
                    System.out.println(jokerWithPlayer-maxJoker);
                }
            }
        }
    }
}

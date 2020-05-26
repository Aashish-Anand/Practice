package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C1358 {
    public static void main(String[] args) throws IOException {
        new C1358().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while(t-- > 0) {
            String s[] = reader.readLine().split(" ");
            long x1 = Long.parseLong(s[0]);
            long y1 = Long.parseLong(s[1]);
            long x2 = Long.parseLong(s[2]);
            long y2 = Long.parseLong(s[3]);

            System.out.println((x2-x1)*(y2-y1) + 1);
        }
    }

}

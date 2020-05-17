package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C1_1354 {
    public static void main(String[] args) throws IOException {
        new C1_1354().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        double PI = 3.14159265359;
        while(t-- > 0) {
            double n = Double.parseDouble(reader.readLine());

            double m = Math.toRadians(180/(2*n));
            double ans = Math.cos(m)/Math.sin(m);
            System.out.printf("%.9f",ans);
            System.out.println();
        }
    }
}
package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1358 {
    public static void main(String[] args) throws IOException {
        new A1358().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while(t-- > 0) {
            String s[] = reader.readLine().split(" ");
            long row = Long.parseLong(s[0]);
            long cols = Long.parseLong(s[1]);

            long lights = (row/2)*cols;

            if(row%2==1) {
                int remaining_rows = 1;
                if (cols % 2 == 0) {
                    lights += cols / 2;
                } else {
                    lights += cols / 2;
                    lights++;
                }
            }

            System.out.println(lights);


        }
    }
}

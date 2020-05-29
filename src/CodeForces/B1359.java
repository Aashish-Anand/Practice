package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1359 {
    public static void main(String[] args) throws IOException {
        new B1359().run();
    }

    private void run() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while(t-- > 0) {
            String s[] = reader.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int costS = Integer.parseInt(s[2]);
            int costL = Integer.parseInt(s[3]);

            int totalCost = 0;
            for (int i = 0; i < n; i++) {
                String str = reader.readLine();
                int j = 0;
                while (j < m) {
                    if (str.charAt(j) == '.') {
                        if (j + 1 < m && str.charAt(j + 1) == '.') {
                            totalCost += 2 * costS>costL?costL:2 * costS;
                            j += 2;
                        } else {
                            totalCost +=costS;
                            j++;
                        }
                    } else {
                        j++;
                    }
                }
            }
            System.out.println(totalCost);
        }

    }
}

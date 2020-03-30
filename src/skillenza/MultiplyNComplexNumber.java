package skillenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class MultiplyNComplexNumber {
    public static void main(String[] args) throws IOException {
        new MultiplyNComplexNumber().run();
    }

    private void run() throws IOException {
        int tests;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        tests = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < tests; i++) {
            int n = Integer.parseInt(reader.readLine().trim());

            int[][] complex = new int[n][2];

            for (int j = 0; j < n; j++) {

                String input = reader.readLine().trim();
                List<String> list = Arrays.asList(input.split(" "));
                complex[j][0] = Integer.parseInt(list.get(0));
                complex[j][1] = Integer.parseInt(list.get(1));

            }

            int a = complex[0][0] * complex[1][0];
            int b = complex[0][0] * complex[1][1];
            int c = complex[0][1] * complex[1][0];
            int d = complex[0][1] * complex[1][1];

            int real = a + (-1 * d);
            int imaginary = b+c;

            for(int j = 2;j<n;j++) {
                a = complex[j][0] * real;
                b = complex[j][1] * real;
                c = complex[j][0] * imaginary;
                d = complex[j][1] * imaginary;

                real = a + (-1 * d);
                imaginary = b + c;
            }

            System.out.println(real + " " + imaginary);
        }

    }
}

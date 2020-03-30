package skillenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given an integer n print a diamond using 1s and 0s.

For eg. given 5 print

    1
   101
  10101
 1010101
101010101
 1010101
  10101
   101
    1
 */
public class DiamondPattern {
    public static void main(String[] args) throws IOException {
        new DiamondPattern().run();
    }

    private void run() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int tests = Integer.parseInt(reader.readLine().trim());

        for(int i = 0;i<tests;i++) {
            int n = Integer.parseInt(reader.readLine().trim());

            int spaces = n-1;
            int row = 2*n -1;
            for(int j = 0;j<row;j++) {

                for(int k = 0;k<spaces;k++) {
                    System.out.print(" ");
                }

                int flag = 1;
                for(int k = 0;k<(row - (2*spaces));k++) {
                    if(flag == 1){
                        System.out.print("1");
                        flag = 0;
                    }
                    else{
                        System.out.print("0");
                        flag = 1;
                    }
                }

                for(int k = 0;k<spaces;k++) {
                    System.out.print(" ");
                }
                if(j < n-1) {
                    spaces--;
                }
                else{
                    spaces++;
                }
                if(j<row) {
                    System.out.println();
                }
            }
        }
    }
}

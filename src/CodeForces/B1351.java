package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1351 {
    public static void main(String[] args) throws IOException {
        new B1351().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while(t-- > 0){
            String s[] = reader.readLine().split(" ");
            int x1 = Integer.parseInt(s[0]);
            int y1 = Integer.parseInt(s[1]);

            s = reader.readLine().split(" ");
            int x2 = Integer.parseInt(s[0]);
            int y2 = Integer.parseInt(s[1]);

            boolean flag = false;
            if(x1 == y2){
                if(x2+y1 == x1){
                    flag = true;
                }
            }
            if(x1 == x2){
                if(y1+y2 == x1){
                    flag = true;
                }
            }

            if(y1 == x2){
                if(y1 == x1+y2) {
                    flag = true;
                }
            }

            if(y1 == y2) {
                if(x1+x2 == y1) {
                    flag = true;
                }
            }

            System.out.println(flag?"Yes":"No");
        }
    }
}

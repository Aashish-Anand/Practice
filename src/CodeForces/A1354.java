package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1354 {
    public static void main(String[] args) throws IOException {
        new A1354().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while(t-- > 0) {
            String[] s = reader.readLine().split(" ");

            long A = Long.parseLong(s[0]);
            long B = Long.parseLong(s[1]);
            long C = Long.parseLong(s[2]);
            long D = Long.parseLong(s[3]);

            long time = B;


            if (A < B) {
                System.out.println(B);
            }

            else if( A-B > 0 && C<=D){
                System.out.println(-1);
            }
            else {
                A -= B;

                long sleepingTimeInEachCycle = C-D;

                if(A>0) {
                    long numberOFCycle = (long) Math.ceil(A / (double)sleepingTimeInEachCycle);
                    A -= numberOFCycle*sleepingTimeInEachCycle;
                    time += C * numberOFCycle;
                }
                if(A>0) {
                    time+= B;
                }
//                while(A>0) {
//                    int sleep = C-D;
//                    time +=C;
//                    A -= sleep;
//                }
                System.out.println(time);
            }
        }
    }
}

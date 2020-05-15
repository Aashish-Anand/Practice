package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1352 {
    public static void main(String[] args) throws IOException {
        new B1352().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while(t-- > 0) {
            String s[] = reader.readLine().split(" ");

            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            boolean odd = false;

            int newNum = n - k+1;
            if(newNum >0 && newNum%2==1){
                odd = true;
            }
            boolean even = false;
            if(!odd) {
                newNum = n - 2*(k-1);
                if(newNum >0 && newNum %2==0) {
                    even = true;
                }
            }

            if(!even && !odd) {
                System.out.println("NO");
            }
            else if(odd) {
                System.out.println("YES");
                for(int i = 0;i<k-1;i++) {
                    System.out.print(1+" ");
                }
                System.out.println(n-k+1);
            }
            else {
                System.out.println("YES");
                for(int i = 0;i<k-1;i++) {
                    System.out.print(2+" ");
                }
                System.out.println(n-2*(k-1));
            }

        }

    }
}

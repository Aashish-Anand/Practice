package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1365 {
    public static void main(String[] args) throws IOException {
        new B1365().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());

            String s[] = reader.readLine().split(" ");
            int arr[] = new int[n];
            int type[] = new int[n];
            int max = Integer.MIN_VALUE;
            boolean sorted = true;
            for(int i = 0;i<n;i++) {
               arr[i] = Integer.parseInt(s[i]);
                if(arr[i]<max) {
                    sorted = false;
                }
                else if(arr[i]>=max) {
                    max = arr[i];
                }
            }


            s = reader.readLine().split(" ");
            boolean found1 = false;
            boolean found0 = false;
            for(int i = 0;i<n;i++) {
                type[i] = Integer.parseInt(s[i]);
                if(type[i]==1) {
                    found1 = true;
                }
                else{
                    found0 = true;
                }
            }
//            System.out.println(max +" "+sorted +" "+found0+" "+found1);

            if(sorted) {
                System.out.println("Yes");
            }
            else if(!found1){
                System.out.println("No");
            }else if(!found0) {
                System.out.println("No");
            }
            else{
                System.out.println("Yes");
            }

        }
    }
}

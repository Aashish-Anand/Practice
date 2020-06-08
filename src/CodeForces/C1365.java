package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
/*
It's an incorrect solution
 */
public class C1365 {
    public static void main(String[] args) throws IOException {
        new C1365().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String a[] = reader.readLine().split(" ");
        String b[] = reader.readLine().split(" ");

        LinkedList<String> ll = new LinkedList<>(Arrays.asList(b));


        int len = 0;

        int i = 0;
        int count = 0;
        int max = 0;
        int k = 0;
        while (i < n) {
            count = 0;
            for(int j= 0;j<n;j++){
                if(a[j].equals(ll.get(j))){
                    count++;
                }
            }
            if(count>max){
                max = count;
            }
            Collections.rotate(ll,1);
            i++;
        }
        System.out.println(max);
    }
}

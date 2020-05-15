package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class A1352 {
    public static void main(String[] args) throws IOException {
        new A1352().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while(t-- > 0) {
            String n = reader.readLine();

            List<Integer> list = new ArrayList<>();

            for(int i = 0;i<n.length();i++) {
                if(n.charAt(i)!='0'){
                    int num = n.charAt(i)-'0';
                    num *= Math.pow(10, n.length()-1-i);
                    list.add(num);
                }
            }

            System.out.println(list.size());
            for(int i = 0;i<list.size();i++) {
                System.out.print(list.get(i) +" ");
            }
            System.out.println();
        }
    }
}

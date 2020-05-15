package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class C1351 {
    public static void main(String[] args) throws IOException {
        new C1351().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while(t-- > 0){
            String s = reader.readLine();

            int n = s.length();
            int i= 0;
            int count = 0;

            Set<String> set = new HashSet<>();

            int curr_x = 0;
            int curr_y = 0;
            int new_x=0, new_y=0;
            
            while(i<n) {

                char ch = s.charAt(i);

                switch (ch) {
                    case 'E': new_x = curr_x+5; new_y = curr_y; break;
                    case 'W': new_x = curr_x-5; new_y = curr_y; break;
                    case 'N': new_x = curr_x; new_y = curr_y+5; break;
                    case 'S': new_x = curr_x; new_y = curr_y-5; break;
                }
                if(set.contains(new_x+"_"+new_y+"_"+curr_x+"_"+curr_y) || set.contains(curr_x+"_"+curr_y+"_"+new_x+"_"+new_y)){
                    count+=1;
                }
                else{
                    count+=5;
                }
                set.add(curr_x+"_"+curr_y+"_"+new_x+"_"+new_y);
                curr_x = new_x;
                curr_y = new_y;

                i++;
            }
            System.out.println(count);
        }
    }
}

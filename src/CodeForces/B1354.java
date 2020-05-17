package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1354 {
    public static void main(String[] args) throws IOException {
        new B1354().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while(t-- > 0) {
            String s = reader.readLine();
            int a = 0;
            int b = 0;
            int c = 0;

            int start = 0;
            int end = 0;
            int min = Integer.MAX_VALUE;
            while(end < s.length()) {

                if(s.charAt(end)=='1') {
                    a++;
                }
                else if(s.charAt(end)=='2'){
                    b++;
                }
                else {
                    c++;
                }

                if(a>0 && b>0 & c>0){
                    int len = end -start+1;
                    if(len < min){
                        min = len;
                    }
                    if(min == 3) {
                        break;
                    }

                    while(start != end && a>0 && b>0 && c>0) {
                        if(s.charAt(start)=='1') {
                            a--;
                        }
                        else if(s.charAt(start)=='2'){
                            b--;
                        }
                        else {
                            c--;
                        }
                        if(a>0 && b>0 & c>0){
                            len = end -start;
                            if(len < min){
                                min = len;
                            }
                        }
                        if(min == 3) {
                            break;
                        }
                        start++;
                    }

                }
                end++;
            }

            System.out.println(min!=Integer.MAX_VALUE?min: 0);
        }
    }
}

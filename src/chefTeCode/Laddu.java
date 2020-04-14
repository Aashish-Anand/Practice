package chefTeCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Laddu {
    public static void main(String[] args) throws IOException {
        new Laddu().run();
    }
    
    private void run() throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(r);

        int t = Integer.parseInt(buff.readLine());

        while(t-->0) {
            String str = buff.readLine();
            String arr[] = str.split(" ");
            int n = Integer.parseInt(arr[0]);
            int devisor = 400;
            if(arr[1].equals("INDIAN")) {
                devisor = 200;
            }

            int laddu = 0;
            for(int i = 0;i<n;i++) {
                str = buff.readLine();
                arr = str.split(" ");
                if(arr[0].equals("CONTEST_WON")) {
                    int bonus = 20 - Integer.parseInt(arr[1]);
                    laddu += 300 + (bonus>=0?bonus:0);
                }else if(arr[0].equals("TOP_CONTRIBUTOR")) {
                    laddu += 300;
                } else if(arr[0].equals("BUG_FOUND")) {
                    laddu += Integer.parseInt(arr[1]);
                } else{
                    laddu += 50;
                }
            }

            System.out.println(laddu/devisor);
        }
    }
}

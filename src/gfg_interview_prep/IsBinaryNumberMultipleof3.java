package gfg_interview_prep;

import java.util.Scanner;

public class IsBinaryNumberMultipleof3 {

    public static void main(String[] args) {
        new IsBinaryNumberMultipleof3().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            String str = sc.next();

            int even = 0;
            int odd = 0;
            for(int i = 0;i<str.length();i++) {
                if(i%2 ==0 && str.charAt(i)=='1') {
                    odd++;
                }
                else if(i%2!=0 && str.charAt(i)=='1') {
                    even++;
                }
            }

            if(Math.abs(odd-even) % 3 == 0){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}

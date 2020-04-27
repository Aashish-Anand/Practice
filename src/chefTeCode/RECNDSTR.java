package chefTeCode;

import java.time.Year;
import java.util.Scanner;

public class RECNDSTR {
    public static void main(String[] args) {
        new RECNDSTR().run();
    }

    private void run( ) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            String str = sc.next();

            StringBuilder s = new StringBuilder(str);
            s.append(str);

            int length = str.length();

            String left = s.substring(1, length+1);
            String right = s.substring(length-1, length+length-1);

            //System.out.println(left + " " +right);

            if(left.equals(right)) {
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }

        }
    }
}

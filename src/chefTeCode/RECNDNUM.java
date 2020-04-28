package chefTeCode;

import java.util.Scanner;
/*
Correct Solution
 */
public class RECNDNUM {
    public static void main(String[] args) {
        new RECNDNUM().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        long t = sc.nextLong();

        while(t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();

            long occurrence = 0;
            if(n==0) {
                long section = k-1;
                if(section>0){
                    occurrence = (section*section)%1000000007;
                }
                occurrence+= section;
            }
            else{
                long a = k / 2;
                long b = k % 2;
                long section = n+a;
                if(b == 0){
                    section--;  // here we moved back to previous section
                }
                occurrence = (section*section)%1000000007;
                if(b==0){
                    // here we are at previous section of the solution that
                    // means solution lies in the next section 
                    occurrence+=section + n;
                }
                else{
                    occurrence+= section-n;
                }
            }
            System.out.println(occurrence%1000000007);
        }
    }
}

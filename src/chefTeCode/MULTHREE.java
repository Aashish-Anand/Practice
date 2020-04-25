package chefTeCode;

import java.util.Scanner;

/*
Not completed
 */
public class MULTHREE {
    public static void main(String[] args) {
        new MULTHREE().run();
    }
    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-->0) {
            long k = sc.nextLong();
            int d0 = sc.nextInt();
            int d1 = sc.nextInt();
            long sum = d0+d1;

            if(k == 2) {
                if(sum % 3 == 0) {
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
                continue;
            }
            long lastDigit = sum%10;

            sum = sum+lastDigit;
            k = k-3;

            while(k > 0) {

                //System.out.println(lastDigit +" " + sum + " "+ k);
                if(lastDigit==6){
                    long quotient = k / 4;
                    sum = sum + (quotient*20);

                    k = k - (quotient*4);
                    if(k == 0){
                      //  break;
                    }
                    else if(k == 1) {  // 2
                        sum += 2;
                    }
                    else if(k == 2) {  // 24
                        sum += 6;
                    }
                    else if(k == 3){ // 248
                        sum += 14;
                    }
                    k = 0;
                    break;
                }
                else if(lastDigit == 0) {
                    k = 0;
                    break;
                }
                else {
                    lastDigit = (lastDigit * 2) % 10;
                    sum = sum + lastDigit;
                    k--;
                }

            }

            System.out.println(sum);
            if(sum % 3== 0) {
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}

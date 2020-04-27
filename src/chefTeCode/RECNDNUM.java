package chefTeCode;

import java.util.Scanner;
/*
Wrong solution
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

            if(k == 1 && n>2) { // for first occurence
                long occurence = returnOccurenceFor1(n);
                System.out.println(occurence);
            }
            else if(k>1 && n > 2) {
                long occurence = returnOccurence(n, k);
            }
            else if(k == 1&& n == 2){
                System.out.println(4);
            }
            else if(n == 1 &&(k == 1)){
                System.out.println(1);
            }
            else if(n == 1 &&(k == 2)){
                System.out.println(3);
            }else if(n == 1 &&(k == 3)){
                System.out.println(5);
            }
            else if(n == 0 && k ==1) {
                System.out.println(0);
            }
            else if(n == 0 && k ==2) {
                System.out.println(2);
            }
        }
    }

    private long returnOccurenceFor1(long n) {

        int a = 4;
        int d = 2;
        n = n-2;
        long diff = (n-1)*d;

        return ((((n*(2*a + diff))/2))%1000000007 +3 + n -1)%1000000007 ;
    }

    private long returnOccurence(long n, long k) {

        long firstIndex = n-1;
        long remainingOccurenace =  k -1;

        long lastOccurance = (int) Math.ceil(remainingOccurenace/2);

        boolean first = remainingOccurenace%2==0?false:true;

        int a = 4;
        int d = 2;

        long newn = firstIndex+ lastOccurance -1;
        long diff = (2 * a + (newn-1)*d);

        long sum = ((newn * diff)/2)%1000000007;

        long numberOfElementInLastOccurence = a + (n-1) * d;

        sum += 3 -1 + (first==true?n:(numberOfElementInLastOccurence-n));

        System.out.println(sum);
        return sum;
    }

}

package skillenza;

import java.util.Scanner;

/*
Need to find out the sum of all the permutation of bits of given number
eg :
3 : 011
Permutation are : 011(3), 101(5), 110(6)
Therefore sum is : 3 + 5 + 6 = 14
 */
public class BitPermutation {
    public static void main(String[] args) {
        new BitPermutation().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            n = sc.nextInt();

            // for each test case changing it to 0;
            bitCount= 0;
            size = 0;

            findBits(n);
            arr = new int[size];

            findSum();
            System.out.println(sum);

            // changing sum to zero
            sum = 0;

        }
    }

    int bitCount = 0;
    int n = 0;
    int arr[];
    int size=0;
    long sum = 0;

    private void findBits(int n) {

        StringBuilder temp = new StringBuilder();

        int bits = 0;
        while(n>0) {
            bits++;
            if(n%2 == 1){
                bitCount++;
            }
            n /= 2;
        }
        size =(int) Math.pow(2,bits);
    }

    private void findSum(){
        arr[0] = 0;
        arr[1] = 1;
        if(arr[0] == bitCount){
            sum += 0;
        }
        if(arr[1] == bitCount) {
            sum += 1;
        }
        for(int i = 2;i<size;i++) {
            if((i&(i-1)) > 0){
                arr[i] = 1 + arr[i&(i-1)];
            }
            else{
                arr[i] = 1;
            }

            if(bitCount == arr[i]){
                sum += i;
            }
        }
    }
}

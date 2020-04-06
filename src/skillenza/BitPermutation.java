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

    int onesBitCount = 0;
    int n = 0;
    int arr[];
    int size=0;
    long sumOfAllPermutationOfBits = 0;

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            n = sc.nextInt();
            // for each test case changing it to 0;
            onesBitCount = 0;
            size = 0;

            findNumberOfBits(n);
            arr = new int[size];

            findSum();
            System.out.println(sumOfAllPermutationOfBits);

            // changing sum to zero
            sumOfAllPermutationOfBits = 0;
        }
    }

    private void findNumberOfBits(int n) {

        int bits = 0;
        while(n>0) {
            bits++;
            if(n%2 == 1){
                onesBitCount++;
            }
            n /= 2;
        }
        size =(int) Math.pow(2,bits); // this will be the size of array
    }

    private void findSum(){
        arr[0] = 0;
        arr[1] = 1;
        if(arr[0] == onesBitCount){
            sumOfAllPermutationOfBits += 0;
        }
        if(arr[1] == onesBitCount) {
            sumOfAllPermutationOfBits += 1;
        }
        for(int i = 2;i<size;i++) {
            if((i&(i-1)) > 0){
                /* checking the number of bits if it greater than 0 then we use previously calculated value
                */
                arr[i] = 1 + arr[i&(i-1)];
            }
            else{
                arr[i] = 1;
            }

            if(onesBitCount == arr[i]){
                sumOfAllPermutationOfBits += i;
            }
        }
    }
}

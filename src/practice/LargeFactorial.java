package practice;

import java.util.Arrays;

public class LargeFactorial {
    public static void main(String[] args) {
        new LargeFactorial().run();
    }

    private void run() {
        int n = 100;

        int arr[] = new int[1000];
        Arrays.fill(arr,0);
        arr[0] = 1;
        int size = 1;  // this is the index upto which we have to change

        for(int i = 1;i<=n;i++) {
            int index = 0;
            int carry = 0;

            while(index < size) {
                int num = arr[index] * i + carry;
                arr[index] = num % 10;
                carry = num / 10;
                index++;
            }

            while(carry!= 0) {
                arr[size] = carry%10;
                carry = carry/10;
                size++;
            }
        }
        for(int i = size-1;i>=0;i--) {
            System.out.print(arr[i]);
        }


    }
}

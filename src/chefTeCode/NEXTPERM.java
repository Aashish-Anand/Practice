package chefTeCode;

import java.util.Arrays;
import java.util.Scanner;

public class NEXTPERM {
    public static void main(String[] args) {
        new NEXTPERM().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 0;i<k;i++) {
            int arr[] = new int[n];

            for(int j = 0;j<n;j++) {
                arr[j] = sc.nextInt();
            }


            int temp[] = findNextPermutation(arr, n);

            for(int j = 0;j<n;j++) {
                System.out.print(temp[j] + " ");
            }
            System.out.println();
        }
    }

    private int[] findNextPermutation(int arr[] , int n) {

        int pos = -1;
        for(int i = n-1;i>0;i--) {
            if(arr[i-1]<arr[i]) {
                pos = i-1;break;
            }
        }
        if(pos == -1) {
            return arr;
        }

        Arrays.sort(arr, pos+1, n);

        int temp = -1;
        for(int i = n-1;i>pos;i--) {
            if(arr[i] > arr[pos]) {
                temp = i;
            }
            else{
                break;
            }
        }

        int tempVar = arr[temp];
        arr[temp] = arr[pos];
        arr[pos] = tempVar;
        return arr;

    }
}

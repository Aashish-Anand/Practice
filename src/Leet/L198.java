package Leet;

import java.util.Arrays;

/*
Not Correct
 */
public class L198 {
    public static void main(String[] args) {
        new L198().run();
    }

    private void run() {
        //int arr[] = {1,2,3,1};
        int arr[] = {226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,
                54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
//        int arr[] = {54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
        System.out.println(rob(arr));
    }

    int result[];
    private int rob(int arr[]) {
        int n = arr.length;
        System.out.println(n);
//        int evenSum = 0;
//        int oddSum = 0;
//        for(int i = 0;i<n;i++) {
//            if(arr[i]%2==0){
//                evenSum+=arr[i];
//            }
//            else{
//                oddSum+=arr[i];
//            }
//        }
//        System.out.println(evenSum+" "+oddSum);
        result = new int[n];
        Arrays.fill(result, -1);
        return Math.max(robUtil(arr, 0), robUtil(arr,1));
    }

    private int robUtil(int arr[], int i) {
        if(i>=arr.length) {
            return 0;
        }
        if(result[i]!=-1) {
            return result[i];
        }
        if(i == arr.length-1){
            //result[i] = arr[i];
            return arr[i];
        }

        result[i] = arr[i] + robUtil(arr,i+2);
        result[i+1] = arr[i+1]+robUtil(arr, i+3);
        System.out.println(i+" " +result[i] +" "+ result[i+1]);
        return Math.max(result[i], result[i+1]);
    }


}

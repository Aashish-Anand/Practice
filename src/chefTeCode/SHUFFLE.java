package chefTeCode;

import sun.awt.image.ImageWatched;

import java.util.*;

/*
Half correct
 */
public class SHUFFLE {

    public static void main(String[] args) {
        new SHUFFLE().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            int number = sc.nextInt();  // this is K in question

            int arr[] = new int[n];

            for(int i = 0;i<n;i++) {
                arr[i] = sc.nextInt();
            }

            // My Solution 1 Half correct
//            boolean flag = true;
//            for(int i = 0;i<n;i++) {
//                if(Math.abs(arr[i]-(i+1))%number != 0) {
//                    flag = false;
//                    break;
//                }
//            }
//            if(flag) {
//                System.out.println("yes");
//            }
//            else {
//                System.out.println("no");
//            }

            // Solution 2
//            int sorted[] = arr.clone();
//            Arrays.sort(sorted);
//
//            for(int i = 0;i<n-number;i++) {
//                for(int j = i+number;j<n;j+=number) {
//                    if(arr[i]>arr[j]){
//                        int temp = arr[i];
//                        arr[j] = arr[i];
//                        arr[i] = temp;
//                    }
//                }
//            }
//
//            boolean flag = true;
//            for(int i = 0;i<n;i++) {
//                if(arr[i]!=sorted[i]) {
//                    flag = false;
//                    break;
//                }
//            }
//
//            if(flag) {
//                System.out.println("no");
//            }
//            else{
//                System.out.println("yes");
//            }

            // Solution 3 - Setter solution

            LinkedList<Integer> temp[] = new LinkedList[number];
            for(int i = 0;i<number;i++) {
                temp[i] = new LinkedList<>();
            }

            for(int i = 0;i<number;i++) {
                for(int j = i;j<n;j+=number) {
                    temp[i].add(arr[j]);
                }
            }

            for(int i = 0;i<number;i++) {
                Collections.sort(temp[i]);
            }


            int isSortedArray[] = new int[n];

            for(int i = 0;i<n;i++) {
                isSortedArray[i] = temp[i%number].poll();
            }

            boolean flag = true;
            for(int i= 0;i<n-1;i++) {
                if(isSortedArray[i+1] < isSortedArray[i]){
                    flag = false;
                }
            }
            if(flag) {
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }


        }

    }
}

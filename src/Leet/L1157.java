package Leet;

import java.util.Arrays;

public class L1157 {
    public static void main(String[] args) {
        new L1157().run();
    }

    class MajorityChecker {

        int newArr[];
        int elements[] = new int[20001];
        public MajorityChecker(int[] arr) {
            newArr = Arrays.copyOf(arr, arr.length);
        }

        public int query(int left, int right, int threshold) {

            Arrays.fill(elements, 0);
            for(int i = left;i<=right;i++) {
                elements[newArr[i]]+=1;
            }

            for(int i = 0;i<=20000;i++) {
                if(elements[i]>=threshold){
                    return i;
                }
            }
            return -1;
        }
    }

    private void run() {
        int arr[] = {1,1,2,2,1,1};
        MajorityChecker mj = new MajorityChecker(arr);
        System.out.println(mj.query(0,5,4));
        System.out.println(mj.query(0,3,3));
        System.out.println(mj.query(2,3,2));
    }
}

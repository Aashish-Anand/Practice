package Leet;

import java.util.*;

public class L454 {
    public static void main(String[] args) {
        new L454().run();
    }
    private void run() {
        int A[] = {0,1,-1};
        int B[] = {-1,1,0};
        int C[] = {0,0,1};
        int D[] = {-1,1,1};
        System.out.print(fourSumCount(A,B,C,D));
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        int n = A.length;
        for(int i = 0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int num = A[i] + B[j];

                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
        }
        int sum = 0;

        for(int i = 0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int num = -(C[i] + D[j]);

                if(map.containsKey(num)) {
                    sum += map.get(num);
                    //map.put(num, 0);
                }
                //map.put(num,0);
            }
        }

        return sum;
    }
}

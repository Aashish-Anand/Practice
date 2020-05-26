package Leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class L1 {
    public static void main(String[] args) {
        new L1().run();
    }

    private void run() {
        int arr[] = {0, 4, 5, 0};
        int n = arr.length;
        System.out.println(find(arr, 0)[0]);
    }

    private int[] find(int nums[], int target) {

        HashMap<Integer, Integer> hash = new HashMap<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int remaining = target - nums[i];
            if (hash.containsKey(remaining)) {
                return new int[]{hash.get(remaining), i};
            } else {
                hash.put(nums[i], i);
            }
        }
        return null;
    }
}

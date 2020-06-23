package Leet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L47 {
    public static void main(String[] args) {
        new L47().run();
    }

    private void run() {
        int nums[] = {1,1,2};
        List<List<Integer>> ll = permuteUnique(nums);
        ll.forEach(a-> System.out.println(a));
    }

    List<List<Integer>> ans = new LinkedList<>();
    private List<List<Integer>> permuteUnique(int[] nums) {
        permute(nums, 0, nums.length-1);
        return ans;
    }

    private void permute(int[] nums, int start, int end) {
        if(start == end){
            List<Integer> newList = new LinkedList<>();
            for(int a: nums) {
                newList.add(a);
            }
            if(!ans.contains(newList)) {
                ans.add(newList);
            }
        }

        else {
            for(int i = start; i<=end;i++) {
                swap(nums, i, start);
                permute(nums, start+1, end);
                swap(nums, i, start);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

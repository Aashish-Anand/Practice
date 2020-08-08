package Leet;

import java.util.Arrays;

public class L673 {
    public static void main(String[] args) {
        new L673().run();
    }

    private void run() {
        int arr[] = {1, 3, 5, 4, 7};
        System.out.println(findNumberOfLIS(arr));
    }

    private int findNumberOfLIS(int nums[]) {

        int ans[] = new int[nums.length];
        ans[0] = 1;
        int counts[] = new int[nums.length];
        Arrays.fill(counts, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && ans[i] < ans[j] + 1) {
                    ans[i] = ans[j] + 1;
                    counts[i] = counts[j];
                } else if (nums[i] > nums[j] && ans[i] == ans[j] + 1) {
                    counts[i] += counts[j];
                }
            }
        }
        for (int a : ans) {
            System.out.print(a + " ");
        }
        System.out.println();

        for (int a : counts) {
            System.out.print(a + " ");
        }
        System.out.println();

        int longest = 0;

        for(int a: ans){
            longest = Math.max(longest,a);
        }

        int answer = 0;
        for(int i = 0;i<ans.length;i++) {
            if(ans[i] == longest){
                answer += counts[i];
            }
        }
        return answer;
    }
}

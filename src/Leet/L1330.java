package Leet;

public class L1330 {
    public static void main(String[] args) {
        new L1330().run();
    }

    private void run() {
        int nums1[] = {2,3,1,5,4};
        int nums2[] = {2,4,9,24,2,1,10};

        System.out.println(maxValueAfterReverse(nums1));
        System.out.println(maxValueAfterReverse(nums2));
    }

    private int maxValueAfterReverse(int nums[]) {
        int n = nums.length;

        int minMax = Integer.MAX_VALUE;
        int maxMin = Integer.MIN_VALUE;

        int originalSum = 0;
        int edgeCase = 0;

        for(int i = 1;i<n;i++) {
            int sum = Math.abs(nums[i] - nums[i - 1]);
            originalSum+=sum;
            minMax = Math.min(minMax, Math.max(nums[i], nums[i-1]));
            maxMin = Math.max(maxMin, Math.min(nums[i], nums[i-1]));
            edgeCase = Math.max(edgeCase, Math.abs(nums[0]-nums[i])-sum);
            edgeCase = Math.max(edgeCase, Math.abs(nums[n-1]-nums[i-1])-sum);
        }


        return originalSum+Math.max(edgeCase,2*(maxMin-minMax));
    }
}

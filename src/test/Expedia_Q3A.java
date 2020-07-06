package test;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Expedia_Q3A {
    public static void main(String[] args) {
        new Expedia_Q3A().run();
    }

    private void run() {
        List<Long> arr = new LinkedList<>();
        arr.add(50L);
        arr.add(40L);
        arr.add(1L);
//        arr.add(4L);
//        arr.add(5L);
//        arr.add(6L);
//        arr.add(7L);
//        arr.add(16L);
        long threshold = 48;
        System.out.println(maxSum(arr, threshold));
        System.out.println(maxSum2(arr, threshold));
    }
    long globalSum = 0;
    long diff = Long.MAX_VALUE;
    private long maxSum(List<Long> arr, long threshold) {


        int i = 0;
        //diff = threshold - 0;
        long sum = 0;
        maxSumUtil(arr, threshold, sum, i);
        return globalSum;
    }

    private void maxSumUtil(List<Long> arr, long threshold, long sum , int i) {

        if(sum <= threshold && threshold - sum <= diff){
            globalSum = sum;
            diff = threshold - sum;
        }
        if( i >= arr.size()){
            return;
        }
        if(sum > threshold){
            return;
        }

        // by including
        maxSumUtil(arr, threshold, sum + arr.get(i), i+1);

        // by excluding
        maxSumUtil(arr, threshold, sum, i+1);
    }

    private long maxSum2(List<Long> arr, long threshold) {
        int i = 0;
        int n = arr.size();

        Collections.sort(arr, Collections.reverseOrder());
        long diff = Long.MAX_VALUE;
        long ans = 0;
        while(i<n){
            int j = i-1;
            long includeSum = arr.get(i);
            long excludeSum = 0;
            while(j>=0) {
                if(includeSum + arr.get(j) <= threshold) {
                    includeSum += arr.get(j);
                }
                if(excludeSum+arr.get(j) <= threshold) {
                    excludeSum+= arr.get(j);
                }

                if(threshold - includeSum>=0 && ans< includeSum) {
                    ans = includeSum;
                }
                if(threshold - excludeSum>=0 && ans < excludeSum) {
                    ans = excludeSum;
                }
//                if(threshold - Math.max(includeSum, excludeSum)>=0 && ans <= Math.max(includeSum, excludeSum)) {
//                    diff = threshold - Math.max(includeSum, excludeSum);
//
//                }
                j--;
            }
            if(threshold - includeSum>=0 && ans< includeSum) {
                ans = includeSum;
            }
            if(threshold - excludeSum>=0 && ans < excludeSum) {
                ans = excludeSum;
            }
            i++;
        }
        return ans;
    }


}

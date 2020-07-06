package Leet;

import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.LinkedList;

public class L1423 {
    public static void main(String[] args) {
        new L1423().run();
    }

    private void run() {
        int arr[] = {1, 79, 80, 1, 1, 1, 200, 1};
        int k = 1;

        //recursive solution
        System.out.println(maxScore(arr, k));

        // this one is the iterative solution - sliding window
        System.out.println(maxScore1(arr, k));
    }

    // this one is the recursive solution
    private int maxScore(int[] cardPoints, int k) {
        if (k == cardPoints.length) {
            int sum = 0;
            for (int i = 0; i < cardPoints.length; i++) {
                sum += cardPoints[i];
            }
            return sum;
        }

        int i = 0;
        int j = cardPoints.length - 1;
        int count = 0;
        int sum = 0;
        maxScoreUtil(cardPoints, k, sum, i, j);
        return maxSum;
    }

    private int maxSum = 0;

    private void maxScoreUtil(int cardPoints[], int k, int sum, int i, int j) {

        if (k <= 0) {
            if (maxSum < sum) {
                maxSum = sum;
            }
            return;
        }
        // consider ith term
        maxScoreUtil(cardPoints, k - 1, sum + cardPoints[i], i + 1, j);
        // consider jth term
        maxScoreUtil(cardPoints, k - 1, sum + cardPoints[j], i, j - 1);
    }

    //recursive solution
    private int maxScore1(int cardPoints[], int k) {
        if (k == cardPoints.length) {
            int sum = 0;
            for (int i = 0; i < cardPoints.length; i++) {
                sum += cardPoints[i];
            }
            return sum;
        }
        int s = cardPoints.length - k;
        int e = cardPoints.length - k;

        int sum = 0;
        int ans = 0;
        for(int i = e;i<cardPoints.length+k-1;i++) {
            sum += cardPoints[i%cardPoints.length];

            if(i - s + 1 > k){
                sum -= cardPoints[s%cardPoints.length];
                s++;
            }
            ans = Math.max(sum, ans);
        }
        
        return ans;
    }
}

package Leet;

import java.util.Arrays;
import java.util.Stack;

/**
 * Very classic question - largest area inside a histogram
 */
public class L84 {
    public static void main(String[] args) {
        new L84().run();
    }

    private void run() {
//        int heights[] = {2, 1, 5, 6, 2, 3};
        int heights[] = {2,3,3,3,2};
        System.out.println(largestRectangleArea(heights));
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }

        int leftMinElementIndex[] = new int[n];
        int rightMinElementIndex[] = new int[n];
        Arrays.fill(leftMinElementIndex, -1);
        Arrays.fill(rightMinElementIndex, n);

        // first we are populating the left min array
        Stack<Integer> s = new Stack<>();
        int i = 0;
        while (i < n) {
            if (!s.isEmpty()) {
                if (heights[s.peek()] < heights[i]) {
                    leftMinElementIndex[i] = s.peek();
                } else {
                    while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                        s.pop();
                    }
                    if (!s.isEmpty() && heights[s.peek()] < heights[i]) {
                        leftMinElementIndex[i] = s.peek();
                    }
                }
            }
            s.push(i);
            i++;
        }
//        for (int a : leftMinElementIndex) {
//            System.out.print(a + " ");
//        }
        System.out.println();
        s.clear();
        i = n-1;
        while (i >= 0) {
            if (!s.isEmpty()) {
                if (heights[s.peek()] < heights[i]) {
                    rightMinElementIndex[i] = s.peek();
                } else {
                    while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                        s.pop();
                    }
                    if (!s.isEmpty() && heights[s.peek()] < heights[i]) {
                        rightMinElementIndex[i] = s.peek();
                    }
                }
            }
            s.push(i);
            i--;
        }
//        for (int a : rightMinElementIndex) {
//            System.out.print(a + " ");
//        }

        i = 0;
        int maxArea = 0;
        for(i = 0;i<n;i++) {
            int area = heights[i] * (rightMinElementIndex[i] - leftMinElementIndex[i] - 1);
            //System.out.print(area +" ");
            if(area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}

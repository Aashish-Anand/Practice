package Leet;

import java.util.Arrays;
import java.util.Stack;

public class L85 {
    public static void main(String[] args) {
        new L85().run();
    }

    private void run() {
        char matrix[][] = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(matrix));
    }

    private int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int heights[] = new int[m];

        int i = 0;
        int max = 0;
        for (i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            max = Math.max(max, maxRectangleAree(heights));
        }
        return max;
    }

    private int maxRectangleAree(int heights[]) {
        int i = 0;
        int n = heights.length;
        if (n == 0) {
            return 0;
        }

        int leftMinElementIndex[] = new int[n];
        int rightMinElementIndex[] = new int[n];
        Arrays.fill(leftMinElementIndex, -1);
        Arrays.fill(rightMinElementIndex, n);

        Stack<Integer> s = new Stack<>();
        i = 0;
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
        s.clear();
        i = n - 1;
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
        i = 0;
        int maxArea = 0;
        for (i = 0; i < n; i++) {
            int area = heights[i] * (rightMinElementIndex[i] - leftMinElementIndex[i] - 1);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;

    }
}

package gfg_interview_prep;

import java.util.Arrays;
import java.util.Stack;

public class maximumRectangleArea {

    public static void main(String[] args) {
        new maximumRectangleArea().run();
    }

    private void run() {
        int arr[] = {6,2,5,4,5,1,6};

        int size = arr.length;

        findMaximumArea(arr, size);
    }

    private void findMaximumArea(int arr[] , int n) {


        int leftMin[] = new int[n];
        int rightMin[] = new int[n];

        Arrays.fill(leftMin, -1);
        Arrays.fill(rightMin, n);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);  // starting with the zero Index

        int i = 1;
        while(i<n) {
            int index = stack.peek();

            while(!stack.isEmpty() && arr[index]> arr[i]) {
                rightMin[index] = i;
                stack.pop();
                if(!stack.isEmpty()) {
                    index = stack.peek();
                }
            }
            stack.push(i);
            i++;
        }

        for(int a: rightMin) {
            System.out.print(a+" ");
        }
        System.out.println();
        stack.clear();
        stack.push(n-1);
        i = n-2;

        while(i>=0) {
            int index = stack.peek();

            while(!stack.isEmpty() && arr[index] > arr[i]) {
                leftMin[index] = i;
                stack.pop();
                if(!stack.isEmpty()) {
                    index = stack.peek();
                }
            }
            stack.push(i);
            i--;
        }

        for(int a : leftMin) {
            System.out.print(a+ " ");
        }

        int maxArea = Integer.MIN_VALUE;

        System.out.println();
        for(i =  0;i<n;i++) {

            int area = (Math.abs(leftMin[i] - rightMin[i])-1 ) * arr[i];

            if(area > maxArea) {
                maxArea = area;
            }
            System.out.print(area+" ");
        }
        System.out.println();
        System.out.println(maxArea);
    }
}

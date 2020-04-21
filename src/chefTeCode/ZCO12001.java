package chefTeCode;

import java.util.Scanner;
import java.util.Stack;

/*
https://www.codechef.com/LRNDSA02/problems/ZCO12001
 */
public class ZCO12001 {
    public static void main(String[] args) {
        new ZCO12001().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int i = 0;
        int maxLength = 0;
        int firstIndex = 0;
        int maxNesting = 0;
        int nestingFirstIndex = 0;
        int firstIndexOfMaxLength = 0;

        Stack<Integer> stack = new Stack<>();
        while (i < n) {
            if (arr[i] == 1 && stack.isEmpty()) {
                stack.push(1);
                firstIndex = i+1;
                if(maxNesting<stack.size()){
                    maxNesting = stack.size();
                    nestingFirstIndex = i+1;
                }
            } else if (arr[i] == 1 ) {
                stack.push(1);
                if(maxNesting<stack.size()){
                    maxNesting = stack.size();
                    nestingFirstIndex = i+1;
                }
            } else if (arr[i] == 2) {
                stack.pop();
                if (stack.isEmpty()) {
                    //maxLength = Integer.max(maxLength, i - firstIndex + 1);
                    if(i-firstIndex+1 > maxLength) {
                        maxLength = i-firstIndex+2;
                        firstIndexOfMaxLength = firstIndex;
                    }
                }
            }
            i++;
        }

        System.out.println(maxNesting + " " + nestingFirstIndex + " " + maxLength + " " + firstIndexOfMaxLength);
    }
}

package gfg_interview_prep;

import java.util.Scanner;
import java.util.Stack;

public class CountSmallerElements {
    public static void main(String[] args) {
        new CountSmallerElements().run();
    }

    // TLE
//    private void run(){
//        Scanner sc = new Scanner(System.in);
//
//        int t = sc.nextInt();
//
//        while(t-- > 0) {
//            int n = sc.nextInt();
//
//            int arr[] = new int[n];
//
//            for(int i = 0;i<n;i++) {
//                arr[i] = sc.nextInt();
//            }
//
//
//            Stack <Integer> stack = new Stack<>();
//            stack.push(arr[n-1]);
//            int ans[] = new int[n];
//            ans[n-1] =  0;
//
//            for(int i = n-2;i>=0;i--) {
//                int num = arr[i];
//                int count = 0;
//                Stack<Integer> tempStack = new Stack<>();
//                while(!stack.isEmpty() && num>stack.peek()) {
//                    tempStack.push(stack.pop());
//                    count++;
//                }
//                ans[i] = count;
//                stack.push(num);
//                while(!tempStack.isEmpty()) {
//                    stack.push(tempStack.pop());
//                }
//            }
//
//            for(int i = 0;i<n;i++) {
//                System.out.print(ans[i] +" ");
//            }
//        }
//    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int i = 0;
            while(i<n-1) {
                int j = n-1;
                int count = 0;
                while(j>i) {
                    if(arr[j]<arr[i]) {
                        count++;
                    }
                    j--;
                }
                i++;
                System.out.print(count +" ");
            }
            System.out.println(0);

        }
    }
}

package Leet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class L32 {
    public static void main(String[] args) throws IOException {
        new L32().run2();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String paren = reader.readLine();

        int i = 0;
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        int longestLength = 0;
        stack.push(-1);
        while(i<paren.length()){
            char ch = paren.charAt(i);

            if(ch == '('){
                stack.push(i);
            }
            else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }
                else {
                    longestLength = Math.max(longestLength, i - stack.peek());
                }
            }
            i++;
        }


        System.out.print(longestLength);
    }

    private void run2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String paren = reader.readLine();

        int maxLen = 0;

        int leftP = 0;
        int rightP = 0;
        for(int i = 0;i<paren.length()-1;i++) {
            char ch = paren.charAt(i);
            if(ch == '(') {
                leftP++;
            }
            else {
                rightP++;
            }

            if(leftP==rightP) {
                maxLen = Math.max(maxLen, 2*rightP);
            }
            else if(rightP>=leftP) {
                leftP=rightP=0;
            }
        }

        leftP = rightP = 0;
        for(int i = paren.length()-1;i>=0;i--) {
            char ch = paren.charAt(i);
            if(ch == '(') {
                leftP++;
            }
            else {
                rightP++;
            }

            if(leftP==rightP) {
                maxLen = Math.max(maxLen, 2*rightP);
            }
            else if(leftP>=rightP) {
                leftP=rightP=0;
            }
        }
        System.out.println(maxLen);
    }
}

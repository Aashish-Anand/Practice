package chefTeCode;

import java.util.Scanner;
import java.util.Stack;

public class INPSTFIX {
    public static void main(String[] args) {
        new INPSTFIX().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            String str = sc.next();

            System.out.println(findPostFix(str, n));
        }
    }

    private String findPostFix(String str, int n) {

        Stack<Character> stack = new Stack<>();
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                newStr.append(ch);
            } else if(ch == ')') {
                while(!stack.isEmpty() && stack.peek()!='('){
                    newStr.append(stack.pop());
                }
                stack.pop();
            } else {

                while( !stack.isEmpty() && stack.peek()!= '(' && precedence(ch) <= precedence(stack.peek())){
                    newStr.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty() && stack.peek()!='(') {
            newStr.append(stack.pop());
        }
        return newStr.toString();
    }

    private int precedence(char ch) {
        switch (ch){
            case '+':
            case '-':
                return 1;

            case '/':
            case '*':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
}

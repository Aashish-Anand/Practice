package Leet;

import java.util.Stack;

public class L856 {
    public static void main(String[] args) {
        new L856().run();
    }

    private void run() {
        String s = "(()()((()())))";
        //s = "(())";
        System.out.println(scoreOfParentheses(s));
    }

    class element{
        char ch;
        int val;
        element(char ch, int val){
            this.ch = ch;
            this.val = val;
        }
    }
    private int scoreOfParentheses(String s) {
        int len = s.length();
        if(len ==0){
            return 0;
        }
        int i = 0;
        Stack<element> stack = new Stack<>();
        while(i<len){
            if(i == 0){
                stack.push(new element('(',0));
            }
            else{
                if(s.charAt(i) == '('){
                    stack.push(new element('(',0));
                }
                else if(s.charAt(i)==')') {
                    if(stack.peek().ch == '('){
                        stack.pop();
                        stack.push(new element('E', 1));
                    }
                    else {
                        int count = 0;
                        while (stack.peek().ch != '(') {
                            count += stack.pop().val;
                        }
                        stack.pop();
                        stack.push(new element('E', count * 2));
                    }
                }
            }
            i++;
        }
        int ans = 0;
        while(!stack.isEmpty()) {
            ans+= stack.pop().val;
        }
        return ans;
    }
}

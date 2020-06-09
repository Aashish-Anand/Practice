package Leet;

import java.util.Stack;

public class L557 {
    public static void main(String[] args) {
        new L557().run();
    }

    private void run() {
        String str = "Let's take LeetCode contest";

        int i = 0;
        String ans = "";
        Stack<Character>stack = new Stack<>();
        while(i<str.length()) {
            char ch = str.charAt(i);

            if(ch != ' ') {
                stack.push(ch);
            }
            else{
                while(!stack.isEmpty()) {
                    ans += stack.pop();
                }
                ans += ' ';
            }
            i++;
        }
        while(!stack.isEmpty()) {
            ans += stack.pop();
        }
        System.out.println(ans);
    }
}

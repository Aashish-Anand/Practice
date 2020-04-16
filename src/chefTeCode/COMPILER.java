package chefTeCode;

import java.util.Scanner;
import java.util.Stack;

public class COMPILER {
    public static void main(String[] args) {
        new COMPILER().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            String str = sc.next();
            System.out.println(calLength(str));
        }
    }

    private long calLength(String str) {
        int n = str.length();

        int ans = 0;
        Stack<Character>stack = new Stack<>();

        for(int i = 0;i<n;i++) {
            if(str.charAt(i) == '<') {
                stack.push('<');
            }
            else{
                if(!stack.isEmpty()) {
                    stack.pop();
                    if(stack.isEmpty()) {
                        ans = i+1;
                    }
                }
                else{
                    break;
                }
            }
        }
        return ans;
    }
}

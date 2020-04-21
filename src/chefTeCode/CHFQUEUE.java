package chefTeCode;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class CHFQUEUE {
    public static void main(String[] args) {
        new CHFQUEUE().run();
    }


    private void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sce = sc.nextInt();

        int arr[] = new int[n];
        long fearFullness = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<n;i++) {
            arr[i]= sc.nextInt();
            if(stack.isEmpty()){
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                    fearFullness =
                            (fearFullness * (i - stack.pop() + 1)) % 1000000007;
                }
                stack.push(i);
            }
        }
        System.out.println(fearFullness);
    }
}

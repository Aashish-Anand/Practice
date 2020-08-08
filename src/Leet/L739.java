package Leet;

import java.util.Stack;

public class L739 {
    public static void main(String[] args) {
        new L739().run();
    }

    private void run() {
        int t[] = {73, 74, 75, 71, 69, 72, 76, 73};

        int ans[] = dailyTemperatures(t);
        for(int a : ans){
            System.out.print(a+" ");
        }
    }
    private int[] dailyTemperatures(int T[]) {

        Stack<Integer>s = new Stack<>();

        s.push(0);
        int i = 1;
        while(i<T.length){
            while(!s.empty() && T[i] > T[s.peek()]){
                T[s.peek()] = i - s.peek();
                s.pop();
            }
            s.push(i);
            i++;
        }

        while(!s.isEmpty()){
            T[s.pop()] = 0;
        }
        return T;
    }
}

package Leet;

import java.util.Collections;
import java.util.PriorityQueue;

public class L1046 {
    public static void main(String[] args) {
        new L1046().run();
    }
    private void run() {
        //int arr[] = {2,7,4,1,8,1};
        int arr[] = {2,2,4,1,4,1};

        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        while(i<arr.length){
            p.add(arr[i++]);
        }

        while(p.size()>1) {
            int b = p.poll();
            int a = p.poll();
            if(b-a>0){
                p.add(b-a);
            }
        }



        if(p.size()>0) {
            System.out.println(p.peek());
        }
        else{
            System.out.println(0);
        }
    }
}

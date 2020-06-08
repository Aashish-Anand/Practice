package Leet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class L347 {
    public static void main(String[] args) {
        new L347().run();
    }

    private void run() {
        int nums[] = {1,1,1,2,2,3,4};
        int k = 3;

        HashMap<Integer,Integer> map= new HashMap<>();

        for(int i = 0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        pq.addAll(map.entrySet());

        LinkedList<Integer> ll = new LinkedList<>();

        for(int i = 0;i<k;i++){
            ll.add(pq.poll().getKey());
        }

        int ans[] = new int[ll.size()];

        for(int i = 0;i<ll.size();i++) {
            ans[i] = ll.get(i);
        }

        for(Integer a: ans) {
            System.out.print(a+" ");
        }
    }
}

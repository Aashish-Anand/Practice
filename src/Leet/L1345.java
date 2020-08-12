package Leet;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class L1345 {
    public static void main(String[] args) {
        new L1345().run();
    }

    private void run() {
        int arr[] = {11,22,7,7,7,7,7,7,7,22,13};

        System.out.println(minJumps(arr));
    }

    class Jumps{
        int index;
        int jump;
        Jumps(int index, int jump) {
            this.index = index;
            this.jump = jump;
        }
    }
    private int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

        for(int i= 1;i<n;i++) {
            if(map.containsKey(arr[i])) {
                LinkedList<Integer> l = map.get(arr[i]);
                l.add(i);
                map.put(arr[i], l);
            }
            else{
                LinkedList<Integer> l = new LinkedList<>();
                l.add(i);
                map.put(arr[i],l);
            }
        }

        Queue<Jumps> q = new LinkedList<>();
        q.add(new Jumps(0,0));

        int min = Integer.MAX_VALUE;
        boolean traversed[] = new boolean[n];
        traversed[0] = true;

        while(!q.isEmpty()){
            Jumps j = q.poll();
            if(j.index == n-1) {
                if(min > j.jump){
                    min = j.jump;
                }
            }
            else {
                if(j.index-1 >=0 && !traversed[j.index-1]){
                    traversed[j.index-1] = true;
                    q.add(new Jumps(j.index-1, j.jump+1));
                }
                if(j.index+1 < n && !traversed[j.index+1]) {
                    traversed[j.index+1] = true;
                    q.add(new Jumps(j.index+1, j.jump+1));
                }

                LinkedList<Integer> l = map.get(arr[j.index]);
                if(null!=l ) {
                    Collections.reverse(l);

                    for (Integer a : l) {
                        if (!traversed[a]) {
                            traversed[a] = true;
                            q.add(new Jumps(a, j.jump + 1));
                        }
                    }
                    map.put(arr[j.index], new LinkedList<>());
                }
            }
        }
        return min;
    }
}

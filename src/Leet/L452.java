package Leet;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class L452 {

    class pair{
        int a,b;
        pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) {
        new L452().run();
    }

    private void run() {
        int[][] points = {{10,16},{2,8},{1,6},{16,87},{1,5},{1,6}};
        System.out.println(findMinArrowShots(points));
    }

    private int findMinArrowShots(int [][]points) {
        int n = points.length;


        PriorityQueue<pair> pq = new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                if(o1.a < o2.a){
                    return o1.a - o2.a;
                }
                if(o1.a == o2.a){
                    return o1.b - o2.b;
                }
                return 1;
            }
        });

        for(int i = 0;i<n;i++) {
            pq.add(new pair(points[i][0], points[i][1]));
        }

        //pq.forEach(a-> System.out.println(a.a+" "+a.b));
//        while (!pq.isEmpty()){
//            pair a = pq.poll();
//            System.out.println(a.a+" "+a.b);
//        }
        int count = 0;
        while(!pq.isEmpty() && pq.size()>1){
            pair first = pq.poll();
            pair second = pq.poll();
            if(first.a == second.a && first.b == second.b){
                pq.add(first);
            }
            else if(second.a > first.b){
                count++;
                pq.add(second);
            }
            else if( second.a <= first.b && second.b <= first.b){
                pq.add(new pair(second.a, second.b));
            }
            else if(second.a <= first.b) {
                pq.add(new pair(second.a, first.b));
            }
        }

        return count+pq.size();
    }
}

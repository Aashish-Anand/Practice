package Leet.NotAtLeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MinimumCostToRope {
    public static void main(String[] args) throws IOException {
        new MinimumCostToRope().run();
    }

    private void run() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];

            String s[] = br.readLine().split(" ");

            for(int i = 0;i<n;i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int i=0;
            while(i<n) {
                pq.add(arr[i]);
                i++;
            }

            int sum = 0;
            while(pq.size()>1) {
                int first = pq.poll();
                int second = pq.poll();
                sum += first+second;
                pq.add(first+second);
            }

            System.out.println(sum);

        }
    }
}

package chefTeCode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SAVKONO {
    public static void main(String[] args) {
        new SAVKONO().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            long n = sc.nextLong();
            long strength = sc.nextLong();

            PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int i = 0;i<n;i++) {
                pq.add(sc.nextLong());
            }

            int count = 0;
            while(true) {
                long pop = pq.poll();
                if(pop == 0){
                    break;
                }
                strength -= pop;
                count++;
                if(strength<=0){
                    break;
                }
                pq.add(pop/2);
            }
            if(strength>0) {
                System.out.println("Evacuate");
            }
            else{
                System.out.println(count);
            }
        }
    }
}

package CodeForces;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B642 {
    public static void main(String[] args) {
        new B642().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();


            PriorityQueue<Integer> a = new PriorityQueue<>();
            PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());

            int i = 0;
            int sum = 0;
            while (i < n) {
                int num = sc.nextInt();
                sum += num;
                a.add(num);
                i++;
            }
            i = 0;
            while (i < n) {
                int num = sc.nextInt();
                b.add(num);
                i++;
            }

            if (k != 0) {
                while (k > 0 && !a.isEmpty() && !b.isEmpty()) {

                    if (a.peek() > b.peek()) {
                        break;
                    } else {
                        a.poll();
                        a.add(b.poll());
                    }
                    k--;
                }
                sum = 0;
                while (!a.isEmpty()) {
                    sum += a.poll();
                }
            }
            System.out.println(sum);
        }
    }
}

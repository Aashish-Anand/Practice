package chefTeCode;

import java.util.Scanner;

public class VIEW2002 {
    public static void main(String[] args) {
        new VIEW2002().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0)  {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            double dist1 = findDist(0,0, x1, y1);
            double dist2 = findDist(0,0, x2, y2);

            if(dist1<dist2) {
                System.out.println("A IS CLOSER");
            }
            else {
                System.out.println("B IS CLOSER");
            }
        }
    }

    private double findDist(int x, int y, int x1, int y1) {

        return Math.sqrt(Math.pow(x1-x,2)+Math.pow(y1-y,2));
    }
}

package chefTeCode;

import java.util.Scanner;

public class TRIQRY {
    public static void main(String[] args) {
        new TRIQRY().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int nPoints = sc.nextInt();
            int query = sc.nextInt();

            int points[][] = new int[nPoints][2];

            for(int i = 0;i<nPoints;i++) {
                points[i][0] = sc.nextInt();
                points[i][1] = sc.nextInt();
            }

            int queryies[][] = new int[query][2];
            for(int i = 0;i<query;i++) {
                queryies[i][0] = sc.nextInt();
                queryies[i][1] = sc.nextInt();
            }

            for(int i = 0;i<query;i++) {
                int x = queryies[i][0];
                int x1 = queryies[i][1];

                int y = 0;
                int y1 = 0;

                int x2 = (int)Math.ceil((x+x1)/2);
                int y2 = (int)Math.abs(Math.ceil((x-x1)/2));

                int count = 0;

                double A = area (x,y,x1,y1,x2,y2);
                for(int j=0;j<nPoints;j++) {

                    int pointx = points[j][0];
                    int pointy = points[j][1];

                    if(isInside(x,y,x1,y1,x2,y2, pointx, pointy, A)) {
                        count++;
                    }
                }
                System.out.print(count+" ");
            }

        }
    }

    static boolean isInside(int x1, int y1, int x2,
                            int y2, int x3, int y3, int x, int y, double A)
    {
        //double A = area (x1, y1, x2, y2, x3, y3);

        double A1 = area (x, y, x2, y2, x3, y3);

        double A2 = area (x1, y1, x, y, x3, y3);

        double A3 = area (x1, y1, x2, y2, x, y);

        return (A == A1 + A2 + A3);
    }

    static double area(int x1, int y1, int x2, int y2,
                       int x3, int y3)
    {
        return Math.abs((x1*(y2-y3) + x2*(y3-y1)+
                x3*(y1-y2))/2.0);
    }
}

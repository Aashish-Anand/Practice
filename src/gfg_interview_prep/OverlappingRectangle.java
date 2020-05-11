package gfg_interview_prep;

import java.util.Scanner;

public class OverlappingRectangle {
    public static void main(String[] args) {
        new OverlappingRectangle().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {

            int rect1_x1 = sc.nextInt();
            int rect1_y1 = sc.nextInt();
            int rect1_x2 = sc.nextInt();
            int rect1_y2 = sc.nextInt();

            int rect2_x1 = sc.nextInt();
            int rect2_y1 = sc.nextInt();
            int rect2_x2 = sc.nextInt();
            int rect2_y2 = sc.nextInt();


            System.out.println(findOverlapping(rect1_x1, rect1_x2, rect1_y1, rect1_y2, rect2_x1, rect2_x2,
                    rect2_y1, rect2_y2));

        }
    }

    private int findOverlapping(int rect1_x1,int rect1_x2, int rect1_y1, int rect1_y2,int rect2_x1,
                                int rect2_x2, int rect2_y1,int rect2_y2) {

        if (rect1_x1 <= rect2_x2 && rect1_x2 >= rect2_x1 &&
                rect1_y1 >= rect2_y2 && rect1_y2 <= rect2_y1)  {
            return 1;
        }
        return 0;
    }
}

package chefTeCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.codechef.com/LRNDSA02/problems/ZCO12002
 */
class contest {
    int start;
    int end;

    contest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

public class ZCO12002 {
    public static void main(String[] args) {
        new ZCO12002().run();
    }

    private void run() {

        Scanner sc = new Scanner(System.in);

        int nContests = sc.nextInt();

        int nVwarmholes = sc.nextInt();

        int nWwarmholes = sc.nextInt();

        contest arr[] = new contest[nContests];

        for (int i = 0; i < nContests; i++) {
            contest con = new contest(sc.nextInt(), sc.nextInt());

            arr[i] = con;
        }

        int goingHoles[] = new int[nVwarmholes];
        for (int i = 0; i < nVwarmholes; i++) {
            goingHoles[i] = sc.nextInt();
        }

        int comingHoles[] = new int[nWwarmholes];
        for (int i = 0; i < nWwarmholes; i++) {
            comingHoles[i] = sc.nextInt();
        }

        Arrays.sort(goingHoles);
        Arrays.sort(comingHoles);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nContests; i++) {
            contest c = arr[i];

            int timeOfNearestGoingHole = findNearestGoingHole(c.getStart(), goingHoles, nVwarmholes);

            int timeOfNearestComingHole = findNearestComingHoles(c.getEnd(), comingHoles, nWwarmholes);

            System.out.println(timeOfNearestGoingHole + " " + timeOfNearestComingHole);
            if (timeOfNearestComingHole != -100 && timeOfNearestGoingHole != -100) {
                if (min > (timeOfNearestComingHole - timeOfNearestGoingHole)) {
                    min = timeOfNearestComingHole - timeOfNearestGoingHole;
                }
            }
        }
        System.out.println(min + 1);

        sc.close();
    }

    private int findNearestGoingHole(int startTime, int goingHoles[], int n) {

        int low = 0;
        int high = n - 1;

        if (startTime < goingHoles[low]) {
            return -100;
        }
        int lowestNumber = 0;
        int minDiff = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (goingHoles[mid] == startTime) {
                return startTime;
            }
            if (goingHoles[mid] - startTime > 0) {
                high = mid - 1;
            } else {
                int diff = startTime - goingHoles[mid];
                if (diff < minDiff) {
                    minDiff = diff;
                    lowestNumber = goingHoles[mid];
                }
                low = mid + 1;
            }
        }
        return lowestNumber;
    }

    private int findNearestComingHoles(int endTime, int comingHole[], int n) {

        int low = 0;
        int high = n - 1;

        if (endTime > comingHole[high]) {
            return -100;
        }

        int number = 0;
        int diff = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (comingHole[mid] == endTime) {
                return endTime;
            }
            if (comingHole[mid] - endTime < 0) {
                low = mid + 1;
            } else {
                if (diff > comingHole[mid] - endTime) {
                    diff = comingHole[mid] - endTime;
                    number = comingHole[mid];
                }
                high = mid - 1;
            }
        }

        return number;

    }
}

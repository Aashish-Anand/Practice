package HackerRank;

import java.util.HashSet;

/**
 * Problem : https://www.hackerrank.com/challenges/flatland-space-stations/problem
 * Dated : 12/March/2020
 */
public class flatlandSpaceStations {

    static int findFlatlandSpaceStations(int n, int[] c) {

        HashSet<Integer> set = new HashSet<>();
        for (int value : c) {
            set.add(value);
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        int nearestStation = -1;

        for(int i = 0;i<n;i++) {
            if(set.contains(i)) {
                leftMax[i] = 0;
                nearestStation = i;
            }
            else{
                if(nearestStation >= 0){
                    leftMax[i] = Math.abs(i-nearestStation);
                }
                else{
                    leftMax[i] = Integer.MIN_VALUE;
                }
            }
        }
        nearestStation = -1;
        for(int i = n-1;i>=0;i--) {
            if(set.contains(i)) {
                rightMax[i] = 0;
                nearestStation = i;
            }
            else{
                if(nearestStation >= 0){
                    rightMax[i] = Math.abs(i-nearestStation);
                }
                else{
                    rightMax[i] = Integer.MIN_VALUE;
                }
            }
        }

        // for(int i = 0;i<n;i++) {
        //     System.out.print(leftMax[i] + " ");
        // }
        // System.out.println();
        // for(int i = 0;i<n;i++) {
        //     System.out.print(rightmax[i] + " ");
        // }

        for(int i = 0;i<n;i++) {
            if(leftMax[i]>=0 && rightMax[i]>=0) {
                leftMax[i] = Math.min(leftMax[i], rightMax[i]);
            }
            else{
                leftMax[i] = Math.max(leftMax[i], rightMax[i]);
            }
        }
        int max =0;
        for(int i = 0;i<n;i++) {
            if(max < leftMax[i]) {
                max = leftMax[i];
            }
        }

        return max;
    }

    public static void main(String []args) {
        int n = 6;
        int numberofSpaceStations = 1;

        int[] stations = {4}; // this is the position of all the space stations

        System.out.println(findFlatlandSpaceStations(n, stations));

    }
}

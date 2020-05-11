package gfg_interview_prep;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Longest_Consecutive_Subsequence {
    public static void main(String[] args) {
        new Longest_Consecutive_Subsequence().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            TreeSet<Integer> set = new TreeSet<>();

            for(int i = 0;i<n;i++) {
                set.add(sc.nextInt());
            }

            int num = set.pollFirst();
            int count = 1;
            int maxCount = -1;
            while(!set.isEmpty()) {
                int getNum = set.pollFirst();
                if(getNum == num+1){
                    count++;
                    num = getNum;
                }
                else{
                    count = 1;
                    num = getNum;
                }

                if(maxCount < count) {
                    maxCount = count;
                }
            }

            System.out.println(maxCount);

        }
    }
}

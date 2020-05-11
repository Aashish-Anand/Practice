package gfg_interview_prep;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class pairCubeCount {

    public static void main(String[] args) {
        new pairCubeCount().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            Map<Integer, Integer> map = new HashMap<>();

            int i = 1;

            while(true) {
                int power =(int) Math.pow(i,3);
                if(power <= n) {
                    map.put(power, i);
                }
                else{
                    break;
                }

                i++;
            }

            int count = 0;
            for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
                int num = n-entry.getKey();
                if(map.containsKey(num)) {
                    count++;
                }
                if(num == 0){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

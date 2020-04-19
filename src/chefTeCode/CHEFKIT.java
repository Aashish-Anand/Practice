package chefTeCode;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
/*
Not completed
 */
public class CHEFKIT {
    public static void main(String[] args) {
        new CHEFKIT().run();
    }
    private void run() {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int v = sc.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int min_value = Integer.MAX_VALUE;
        int max_val = Integer.MIN_VALUE;
        for(int i = 0;i<m;i++) {

            int key = sc.nextInt();
            int value = sc.nextInt();
            if(key < min_value) {
                min_value = key;
            }
            if(key > max_val) {
                max_val = key;
            }
            if(map.containsKey(key)) {
                map.put(key, map.get(key)+value);
            }
            else {
                map.put(key, value);
            }
        }


        int i = min_value;

        int totalveg = 0;
        int prev = 0;
        boolean flag = true;

        while(true) {
            if(map.containsKey(i)) {
                if (map.get(i) < v) {
                    totalveg += map.get(i);
                    prev = 0;
                } else {
                    totalveg += v;
                    int remaining=0;
                    if(!flag) {
                        remaining = map.get(i) - v - prev > 0 ? map.get(i) - v - prev : 0;
                    }
                    else{
                        remaining =  map.get(i) - v;
                    }
                    prev = remaining;
                    int nextday = i + 1;
                    if (map.containsKey(nextday)) {
                        map.put(nextday, map.get(nextday) + remaining);
                        flag = true;
                    } else {
                        map.put(nextday, remaining);
                        flag = false;
                    }
                }
            }

            i++;

            if(i > max_val+1) {
                break;
            }

        }

        System.out.println(totalveg);
    }
}

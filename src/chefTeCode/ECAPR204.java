package chefTeCode;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ECAPR204 {
    public static void main(String[] args) {
        new ECAPR204().run();
    }
    private void run() {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while(t-- >0) {
            long n = sc.nextLong();

            Map<Long, Long> map = new TreeMap<Long, Long>();
            for(int i = 0;i<n;i++) {
                long num = sc.nextLong();

                if(map.containsKey(num)) {
                    map.put(num, map.get(num)+1);
                }
                else{
                    map.put(num, (long) 1);
                }
            }

            for(Map.Entry<Long, Long> entry : map.entrySet()) {
                System.out.println(entry.getKey()+":"+entry.getValue());
            }
        }
    }
}

package chefTeCode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SUTCBIN {
    public static void main(String[] args) {
        new SUTCBIN().run();
    }

    private void run() {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        LinkedHashMap<Long, Long> map = new LinkedHashMap<>();
        for(int i =0;i<n;i++) {
            long num = sc.nextLong();

            if(map.containsKey(num)) {
                long count = map.get(num);
                map.put(num, count+1);
            }
            else {
                map.put(num,(long)1);
            }
        }

        for(Map.Entry<Long, Long> entry : map.entrySet()) {
            System.out.print(entry.getKey()+entry.getValue()+" ");
        }

    }
}

package chefTeCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CORUS {
    public static void main(String[] args) {
        new CORUS().run();
    }

    private void run() {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
             long n = sc.nextLong();

             long queries = sc.nextLong();

             String str = sc.next();

             long arr[] = new long[26];

             for(int i = 0;i<n;i++) {
                 arr[str.charAt(i) - 'a']++;
             }

             Map<Long, Long> map = new HashMap<Long,Long>();

             while(queries-- > 0) {
                 long num = sc.nextLong();

                 if(map.containsKey(num)) {
                     System.out.println(map.get(num));
                 }
                 else {
                     long queueSize = 0;
                     for (int i = 0; i < 26; i++) {
                         if (arr[i] > num) {
                             queueSize += arr[i] - num;
                         }
                     }
                     System.out.println(queueSize);
                     map.put(num, queueSize);
                 }
             }
        }
    }
}

package test;

import sun.awt.datatransfer.DataTransferer;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Expedia_Q2S {
    public static void main(String[] args) throws IOException {
        new Expedia_Q2S().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int arr[] = new int[n];
            String temp[] = reader.readLine().split(" ");
            int k = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(temp[i]);
            }

            HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

            for (int i = 0; i < arr.length; i++) {
                hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
            }

            LinkedList<Map.Entry<Integer, Integer>> ll = new LinkedList(hash.entrySet());

            Collections.sort(ll, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                    return e1.getValue() - e2.getValue();
                }
            });

            HashMap<Integer, Integer> linked = new LinkedHashMap<>();
            for (Map.Entry<Integer, Integer> entry : ll) {
                linked.put(entry.getKey(), entry.getValue());
            }

            linked.forEach((a, b) -> System.out.println(a + " " + b));


            int i = 0;
            for (Map.Entry<Integer, Integer> e : linked.entrySet()) {
                 int num = e.getValue();
                 if(k>=num){
                     k = k-num;
                 }
                 else{
                     System.out.print(linked.size()-i);
                     break;
                 }
                 i++;
            }

            //System.out.println(linked.size());

        }
    }
}

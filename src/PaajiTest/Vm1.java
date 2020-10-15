package PaajiTest;

import java.util.*;

public class Vm1 {
    public static void main(String[] args) {
        new Vm1().run();
    }

    private void run() {

        List<String> item = new ArrayList<>();

        item.add("abc");
        item.add("abc");
        item.add("abc");
        item.add("bcd");
        item.add("bcd");
        item.add("bcd");
        item.add("def");
        item.add("sas");

        Map<String, Integer> count = new HashMap<>();

        for(String a : item) {
            count.put(a, count.getOrDefault(a,0)+1);
        }

        List<Map.Entry<String,Integer>> list = new LinkedList<>(count.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if( o2.getValue().compareTo(o1.getValue()) ==0 ){
                    return o2.getKey().compareTo(o1.getKey());
                }
                else{
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });

        for (Map.Entry<String, Integer> a : list) {
            System.out.println(a.getKey()+" "+a.getValue());
        }
    }
}

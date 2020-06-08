package Leet;

import java.util.*;

public class L451 {
    public static void main(String[] args) {
        new L451().run2();
    }

    private void run() {
        String str = "truee";
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i = 0;i<str.length();i++) {
            char ch = str.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }

        LinkedList<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        map = new LinkedHashMap<>();

        for(Map.Entry<Character, Integer> ll: list) {
            map.put(ll.getKey(), ll.getValue());
        }

        String newStr = "";
        for(Map.Entry<Character, Integer> itr : map.entrySet()) {
            //System.out.println(itr.getKey()+" "+itr.getValue());

            for(int i = 0;i<itr.getValue();i++) {
                newStr+=itr.getKey();
            }
        }
        System.out.println(newStr);
    }

    //Method 2 More efficient
    private void run2() {
        String str = "trruee";
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }


        // here is the comparator
        PriorityQueue<Map.Entry<Character, Integer>> pq =
                new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        pq.addAll(map.entrySet());

        String ans = "";
        for(Map.Entry<Character, Integer> entry : pq) {

            for(int i = 0;i<entry.getValue();i++) {
                ans+= entry.getKey();
            }
        }

        System.out.println(ans);
    }
}

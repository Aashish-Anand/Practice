package Leet;

import java.util.*;

class pair implements Comparable<pair>{
    int a, b;

    pair(int a, int b) {
        this.a= a;
        this.b = b;
    }

    @Override
    public int compareTo(pair o) {
        pair obj = (pair) o;
        return this.a - obj.a;
    }
}

public class L763 {
    public static void main(String[] args) {
        new L763().run();
    }

    private void run() {
        //String s = "ababcbacadefegdehijhklij";
        String s = "ababcbacadefegdehijhklij";
        int n = s.length();
        int start[] = new int[26];
        int end[] = new int[26];

        Arrays.fill(start, -1);
        Arrays.fill(end, -1);
        for (int i = 0; i < n; i++) {
            if (start[s.charAt(i) - 'a'] == -1) {
                start[s.charAt(i) - 'a'] = i;
            }
            end[s.charAt(i) - 'a'] = i;
        }

        TreeSet<pair> pairList = new TreeSet<>();
        for (int i = 0; i < 26; i++) {
            if(start[i]!=-1) {
                pair p = new pair(start[i], end[i]);
                pairList.add(p);
            }
            //System.out.println(start[i] + " " + end[i]);
        }


        pair p = pairList.pollFirst();
//        pair p = pairList.get(0);
        int selectedStart = p.a;
        int selectedEnd = p.b;


        List<Integer> ans = new java.util.LinkedList<>();
        System.out.println(selectedStart+" "+selectedEnd);
        for(pair a: pairList) {
            System.out.println(a.a+" "+a.b);
        }

        for(pair a: pairList) {

            int currentStart = a.a;
            int currentEnd = a.b;

            if(currentStart>selectedEnd) {
                ans.add(selectedEnd-selectedStart+1);
                selectedStart = currentStart;
                selectedEnd = currentEnd;
            }
            else if(selectedEnd < currentEnd) {
                selectedEnd = currentEnd;
            }
        }
        ans.add(selectedEnd-selectedStart+1);

        for(Integer i : ans) {
            System.out.println(i);
        }
    }
}

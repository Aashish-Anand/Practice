package Subsequence_And_Subarray;

import java.util.*;

public class GenerateAllSubArray {
    public static void main(String[] args) {
        new GenerateAllSubArray().run();
    }

    private void run() {
        String str = "abcde";
        int n  = str.length();
        List<String> list = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            for(int j = i+1;j<n;j++) {
                String s = str.substring(i,j);
                //System.out.println(s);
                list.add(s);
            }
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        System.out.println();
        for(String a : list) {
            System.out.println(a);
        }

    }
}

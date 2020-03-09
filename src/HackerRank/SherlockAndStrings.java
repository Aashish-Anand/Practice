package HackerRank;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times.
 * It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times.
 * Given a string , determine if it is valid. If so, return YES, otherwise return NO.
 */
public class SherlockAndStrings {

    private static String check(String abc, int len) {

        Map<Character, Integer> map = new TreeMap<>();
        Map<Integer, Integer> mapCount = new TreeMap<>();
        int max = Integer.MIN_VALUE;
        int secondMax = 0;

        for(Character ch : abc.toCharArray()) {
            if(!map.containsKey(ch)) {
                map.put(ch,1);
            }
            else{
                int count = map.get(ch);
                map.put(ch,count+1);
            }
        }

        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if(value > max) {
                max = value;
            }
            if(!mapCount.containsKey(value)) {

                mapCount.put(value,1);
            }
            else{
                mapCount.put(value,mapCount.get(value)+1);
            }
        }

//        if(mapCount.size() == 1){
//            return true;
//        }
//        if(mapCount.size() > 2) {
//            return false;
//        }
//
//        for(Map.Entry<Integer,Integer> entry : mapCount.entrySet()) {
//            if(((max-entry.getKey()) == 1) && ((mapCount.get(max)==1 && entry.getValue() == 1) || (mapCount.get(max)==1 && entry.getValue()>1) || (mapCount.get(max)>1 && entry.getValue()==1))){
//                return true;
//            }
//        }
        int min = Collections.min(map.values());
        max = Collections.max(map.values());
        String output= (mapCount.size() == 1  ||( mapCount.size() <= 2 && (mapCount.get(min) <= 1 || mapCount.get(max) <= 1) && (max-min ==1))) ? "YES" : "NO";
        return output;

    }
    public static void main(String[] args) {
        String abc = "";
        Scanner sc = new Scanner(System.in);
        abc = sc.next();
        System.out.println(check(abc, abc.length()));
    }
}

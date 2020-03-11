package HackerRank;

import java.util.HashMap;
import java.util.Map;

public class MakeAnaGram {

    static int makingAnagrams(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0;i<s1.length();i++) {
            if(!map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i),1);
            }
            else{
                map.put(s1.charAt(i),map.get(s1.charAt(i))+1);
            }
        }
        for(int i = 0;i<s2.length();i++) {
            if(!map.containsKey(s2.charAt(i))) {
                map.put(s2.charAt(i),-1);
            }
            else{
                map.put(s2.charAt(i),map.get(s2.charAt(i))-1);
            }
        }

        int count = 0;
        for(Map.Entry<Character, Integer> m : map.entrySet()){
            if(m.getValue()!=0){
                count+=Math.abs(m.getValue());
            }
            System.out.println(m.getKey() +" " + m.getValue());
        }
        return count;

    }
    public static void main(String []args) {
//        String a = "absdjkvuahdakejfnfauhdsaavasdlkj";
//        String b = "djfladfhiawasdkjvalskufhafablsdkashlahdfa";

        String a = "aab";
        String b = "cccb";
        System.out.println(makingAnagrams(a,b));

    }
}

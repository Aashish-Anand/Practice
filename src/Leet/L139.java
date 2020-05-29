package Leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L139 {
    public static void main(String[] args) {
        new L139().run();
    }
    private void run() {
        String s = "catsandog";
        List<String> dict = new ArrayList<>();
        dict.add("cats");
        dict.add("dog");
        dict.add("sand");
        dict.add("and");
        dict.add("cat");

        checkAndPrintAll(s, dict,"");

        if(checkIfExistRecursion(s, dict)) {
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }

        int lookUp[] = new int[s.length()+1];
        Arrays.fill(lookUp,-1);
        if(checkIfExistDP(s, dict, lookUp)){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }


        if(checkIfExistDP2(s, dict)){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }

    private void checkAndPrintAll(String s, List<String> dict, String ans){

        if(s.length()==0){
            System.out.println(ans);
        }

        for(int i = 1;i<=s.length();i++) {
            String sub = s.substring(0,i);

            if(dict.contains(sub)) {
                checkAndPrintAll(s.substring(i), dict, ans+" "+sub);
            }
        }
    }
    private boolean checkIfExistRecursion(String s, List<String> dict) {

        if(s.length()==0){
            return true;
        }
        for(int i = 1;i<=s.length();i++) {
            String sub = s.substring(0,i);

            if(dict.contains(sub) && checkIfExistRecursion(s.substring(i),dict)){
                return true;
            }
        }
        return false;
    }

    private boolean checkIfExistDP(String s, List<String> dict, int lookup[]){
        int n = s.length()-1;

        if(n==0){
            return true;
        }

        if(lookup[n]==-1) {
            lookup[n]=0;
            for (int i = 1; i <= n; i++) {
                String sub = s.substring(0,i);

                if(dict.contains(sub) && checkIfExistDP(s.substring(i), dict, lookup)){
                    lookup[n] = 1;
                    return true;
                }
            }
        }

        return lookup[n]==1;
    }

    private boolean checkIfExistDP2(String s, List<String> dist) {

        boolean lookUp[] = new boolean[s.length()+1];

        lookUp[s.length()] = true;

        for(int i = s.length();i>=0;i--){
            String str = "";
            for(int j = i;j<s.length();j++) {
                str+=s.charAt(j);
                if(dist.contains(str)) {
                    if(lookUp[j+1]){
                        lookUp[i] = true;
                    }
                }
            }
        }
        return lookUp[0];
    }
}

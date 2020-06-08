package Leet;

import java.util.Arrays;
import java.util.LinkedList;

public class L387 {
    public static void main(String[] args) {
        new L387().run();
    }

    private void run() {
        String s = "a";
        String ans = "1.1.1.1";
        ans = ans.replaceAll("\\.","[.]");
        System.out.println(ans);
        int n = s.length();

        int arr[] =  new int[27];

        Arrays.fill(arr, -1);

        LinkedList<Character> ll = new LinkedList<>();

        for(int i = 0;i<s.length();i++) {
            char ch = s.charAt(i);
            int index = ch-'a';
            if(arr[index]!=-1 && arr[index]!=-10){
                ll.removeFirstOccurrence(ch);
                arr[index] = -10;
            }
            else if(arr[index]==-1){
                ll.add(ch);
                arr[ch-'a'] = i;
            }
        }

        if(ll.size()>0) {
            System.out.print(arr[ll.get(0) - 'a']);
        } else {
            System.out.println(-1);
        }
    }
}

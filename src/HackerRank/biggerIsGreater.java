package HackerRank;

import java.util.Arrays;

public class biggerIsGreater {

    private static String findBiggerIsGreater(String str) {
        char[] ch = str.toCharArray();
        int len = str.length();

        int pos = -1;
        for(int i = len-2;i>=0;i--) {
            if(ch[i] < ch[i+1]){
                pos = i;
                break;
            }
        }
        if(pos == -1) {
            return str;
        }
        char next = '{';  // character just after 'z'
        int nextPos = -1;
        for(int i = pos+1;i<len;i++) {
            if(ch[i]>ch[pos] && next > ch[i]) {
                next = ch[i];
                nextPos = i;
            }
        }

        char temp = ch[pos];
        ch[pos] = ch[nextPos];
        ch[nextPos] = temp;

        Arrays.sort(ch, pos+1,len);
        return String.valueOf(ch);

    }

    public static void main(String[] args) {
        String str = "aa";

        System.out.println(findBiggerIsGreater(str));
    }
}

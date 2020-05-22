package Leet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class L43 {
    public static void main(String[] args) throws IOException {
        new L43().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        System.out.println(findProduct(a,b));
    }
    private String findProduct(String a, String b) {

        if(a.length()==0 || b.length()==0){
            return Integer.toString(0);
        }
        if(a.length()<b.length()){
            String temp = a;
            a = b;
            b = temp;
        }

        Stack<Integer>st = new Stack<>();
        StringBuffer s = new StringBuffer();

        int bLen = b.length();

        int append = 0;

        for(int i = bLen-1;i>=0;i--) {
            StringBuffer newS = new StringBuffer();

            int aLen = a.length()-1;
            int j = 0;
            int carry = 0;
            while(j<append) {
                newS.append(s.charAt(j));
                j++;
            }
            while(aLen>=0) {
                int num = (a.charAt(aLen)-'0')*(b.charAt(i)-'0') + carry;
                if(j<s.length()) {
                    num+= (s.charAt(j)-'0');
                    j++;
                }

                newS.append(num%10);
                carry = num/10;
                aLen--;
            }
            while(j<s.length()) {
                int num = (s.charAt(j)-'0')+carry;
                newS.append(num%10);
                carry = num/10;
                j++;
            }
            while(carry>0) {
                newS.append(carry%10);
                carry/=10;
            }
            s = newS;
            append++;
        }

        int count = 0;
        for(int i = 0;i<s.length();i++) {
            if(s.charAt(i)=='0') {
                count++;
            }
        }
        if(count == s.length()){
            return Integer.toString(0);
        }

        return s.reverse().toString();
    }
}

package Subsequence_And_Subarray;

import java.util.Scanner;

public class longest_Subsequence_With_Consonants {
    public static void main(String[] args) {
        new longest_Subsequence_With_Consonants().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.print(longestSub(str));
    }

    private String longestSub(String s) {

        StringBuilder str = new StringBuilder();
        for(int i = 0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(checkConsonants(ch)) {
                str.append(ch);
            }
        }

        return str.toString();
    }

    private boolean checkConsonants(char ch) {

        ch = Character.toLowerCase(ch);

        if(!(ch == 'a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')) {
            return true;
        }
        return false;
    }
}

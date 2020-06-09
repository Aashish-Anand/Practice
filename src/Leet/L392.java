package Leet;

public class L392 {
    public static void main(String[] args) {
        new L392().run();
    }
    private void run() {
        String s = "acb";
        String t = "ahbgdc";

        int i = 0;
        int j = 0;

        while(i<t.length() && j<s.length()) {
            char sChar = s.charAt(j);
            char tChar = t.charAt(i);

            if(tChar == sChar){
                j++;
            }
            i++;
        }

        if(j<=s.length()-1){
            System.out.println(false);
        }
        else {
            System.out.println(true);
        }
    }
}

package HackerRank;

public class appendAndDelete {
    static String appendAndDelete(String s, String t, int k) {
        if(s.equals(t) && k>=(s.length()*2)){
            return "Yes";
        }
         else if(s.equals(t) && k<(s.length()*2)){
             return "No";
         }

        int slen = s.length();
        int tlen = t.length();

        int i = 0;
        int j = 0;
        while(i<s.length() && j<t.length() && s.charAt(i) == t.charAt(j)) {
            i++;
            j++;
        }
//        if(i == s.length() && j == t.length() && k<2*s.length()) {
//            return "No";
//        }

        int remain = k-(s.length()-1) - (t.length()-1);
        if(remain == 0){
            return "Yes";
        }
        if(remain < 0){
            return "No";
        }
        if(remain%2 == 0){
            return "Yes";
        }
        else{
            if(remain >= (2*i)){
                return "Yes";
            }else {
                return "No";
            }
        }

    }
    public static void main(String []args) {
        System.out.println(appendAndDelete("abc","ab",4));
    }
}

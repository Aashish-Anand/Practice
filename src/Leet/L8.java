package Leet;

public class L8 {
    public static void main(String[] args) {
        new L8().run();
    }

    private void run() {
        System.out.println(myAtoi(" 12344abc"));
    }

    private int myAtoi(String str) {

        StringBuilder ans = new StringBuilder();
        for(int i = 0;i<str.length();i++) {
            if(ans.length()==0 && str.charAt(i)==' '){
                continue;
            }
            else if((str.charAt(i)=='+' || str.charAt(i)=='-') && ans.length()==0){
                ans.append(str.charAt(i));
            }
            else if(str.charAt(i)!=' ' &&Character.isDigit(str.charAt(i))) {
                ans.append(str.charAt(i));
            }
            else {
                break;
            }
        }
        return convertString(ans.toString());
    }
    private int convertString(String result) {
        int ans = 0;
        if(!result.isEmpty() && !result.equals("+") && !result.equals("-")) {
            try {
                ans = Integer.parseInt(result);
            }
            catch (Exception e) {
                if(result.charAt(0)=='-'){
                    ans = Integer.MIN_VALUE;
                }
                else{
                    ans = Integer.MAX_VALUE;
                }
            }
        }
        return ans;
    }
}

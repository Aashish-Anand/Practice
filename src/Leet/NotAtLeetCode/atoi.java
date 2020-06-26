package Leet.NotAtLeetCode;

public class atoi {
    public static void main(String[] args) {
        new atoi().run();
    }

    private void run() {
        String str = "   -42";

        StringBuilder finalString = new StringBuilder();

        for(Character c : str.toCharArray()) {

            if(c == ' ' && finalString.length() == 0){
                continue;
            }
            else if(c == '-' || c == '+' && finalString.length()==0) {
                finalString.append(c);
            }
            else if(Character.isDigit(c)){
                finalString.append(c);
            }
            else{
                break;
            }
        }

        System.out.println(ParseString(finalString.toString()));
    }
    private int ParseString(String finalString) {
        int num = 0;
        if(!finalString.isEmpty() && !finalString.equals("+") && !finalString.equals("-")) {
            try{
                num = Integer.parseInt(finalString);
            }
            catch (Exception e) {
                if (finalString.charAt(0) == '-') {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return num;
    }
}

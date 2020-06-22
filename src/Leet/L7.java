package Leet;

public class L7 {
    public static void main(String[] args) {
        new L7().run();
    }

    private void run() {
        int abc = 000001;

        System.out.println(reverse(abc));
    }

    private int reverse(int x) {

        String s = Integer.toString(x);
        System.out.println(s);

        StringBuilder ans = new StringBuilder();

        if((s.charAt(0) == '-' ) && ans.length()==0){
            ans.append(s.charAt(0));
        }
        int index = s.length()-1;

        while(index>=0 && s.charAt(index)=='0'){
            index--;
        }
        for(int i = index;i>=0;i--) {
            if(Character.isDigit(s.charAt(i))) {
                ans.append(s.charAt(i));
            }
        }

        int answer = 0;
        try{
            answer = Integer.parseInt(ans.toString());
        }
        catch (Exception e){
            answer = 0;
        }
        return  answer;
    }
}

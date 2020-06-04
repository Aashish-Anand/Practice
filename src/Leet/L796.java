package Leet;

public class L796 {
    public static void main(String[] args) {
        new L796().run();
    }

    private void run() {
        String A = "abcde";
        String B = "eabcd";

        if(A.length()!=B.length()){
            return;
        }
        A = A+A;

        int len = A.length();
        int i = 0;
        int j = 0;

        boolean flag = false;
        while(i<A.length()-B.length()){
            while(j<B.length() && A.charAt(i)==B.charAt(j)){
                i++;
                j++;
                flag = true;
            }

            if(j == B.length()) {
                System.out.println("Yes");
                break;
            }
            else{
                j=0;
            }

            if(!flag){
                i++;
            }
            flag = false;
        }
    }
}

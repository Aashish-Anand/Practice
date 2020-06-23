package Leet;

import java.util.Stack;

public class L125 {
    public static void main(String[] args) {
        new L125().run();
    }

    private void run() {
        //String str = "A man, a plan, a canal: Panama";
        String str = "race a car";
        int len = str.length();

        int countChar = 0;
        for(Character c : str.toCharArray()) {
            if(Character.isDigit(c) || Character.isLetter(c)) {
                countChar++;
            }
        }
        System.out.println(Math.ceil(countChar/2.0));

        Stack<Character> s = new Stack<>();
        int i = 0;
        for(Character c : str.toCharArray()) {
            if(Character.isDigit(c) || Character.isLetter(c)) {
                s.push(Character.toLowerCase(c));
            }
            if(s.size() >= (int)(Math.ceil(countChar/2.0))){
                break;
            }
            i++;
        }

        System.out.println("This is our stack");

        if(countChar%2!= 0){
            s.pop();
        }
        i++;
        s.forEach(a-> System.out.print(a+" "));
        for(int j = i;j<len;j++) {
            if(Character.isDigit(str.charAt(j)) || Character.isLetter(str.charAt(j))) {
                if(s.peek() == Character.toLowerCase(str.charAt(j))){
                    s.pop();
                }
                else {
                    System.out.println(false);
                }
            }
        }
        if(s.size()==0){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}

package test;


public class Expedia_Q1A {
    public static void main(String[] args) {
        new Expedia_Q1A().run();
    }

    private void run() {
        String message = "aaaa";
        System.out.println(compressedString(message));
    }
    private String compressedString(String message) {

        StringBuilder str = new StringBuilder();

        int i = 0;
        int j = 0;

        int n = message.length();
        while(i<n) {
            j = i+1;
            while (j<n && message.charAt(i)==message.charAt(j)) {
                j++;
            }
            if(j-i>1) {
                str.append(message.charAt(i)+""+(j-i));
            }
            else{
                str.append(message.charAt(i));
            }
            i = j;
        }
        return str.toString();
    }
}

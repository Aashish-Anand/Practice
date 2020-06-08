package Leet;

public class L231 {
    public static void main(String[] args) {
        new L231().run();
    }

    private void run() {
        int n = 258;
        double num = Math.log10(n)/Math.log10(2.0);
        //System.out.println(Math.floor(num));
        System.out.println(Math.floor(num) == num);
    }
}

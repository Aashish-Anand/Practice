package Leet;

public class L476 {
    public static void main(String[] args) {
        new L476().run();
    }

    private void run(){
        int n = 2147483647;

        int originalNum = n;

        long i = 1;
        while(i<=originalNum ){
            System.out.println(i);
            n^=i;
            i <<=1;
        }
        System.out.println(n);
    }
}

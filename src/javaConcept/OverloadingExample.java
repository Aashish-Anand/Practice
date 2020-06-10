package javaConcept;

public class OverloadingExample {
    public static void main(String[] args) {
        new OverloadingExample().run();
    }

    private int sum(int a){
        return a;
    }
    private int sum(double a){
        return (int) a;
    }

//    private double sum(int a,int c){
//        return a;
//    }
    private void run() {

    }
}

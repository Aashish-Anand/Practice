package practice;

import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        new TestClass().run2();
    }

    private void run2() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {

            String str = sc.nextLine();
            String s[] = str.split(" ");

            for(String a: s) {
                System.out.print(a+ " ");
            }
        }
    }

    private void run() {
        int a= 4;
        int b = 2;

        System.out.println(run1(a,b));
    }

    private Integer run1(int a, int b) {
        for(int i = 0;i<1;i++) {
            try{
                int x = a/b;
                return x;
            }
            catch(Exception e){
                System.out.println(e);
                System.out.println("Catch");
                return null;
            }finally {
                System.out.println("Inside the finally block");
                //break;
                return null;
            }
        }
        return 0;
    }
}


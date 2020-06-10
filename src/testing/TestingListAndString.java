package testing;

import java.util.ArrayList;
import java.util.List;

public class TestingListAndString {
    public static void main(String[] args) {
        new TestingListAndString().run();
    }

    private void f1(List<Integer> list1) {
        list1.add(10);
        list1.add(20);
    }

    private void f2(List<Integer> list2) {
        list2.add(40);
        list2 = new ArrayList<>();
        list2.add(50);
    }
    private void f3(List<Integer> list1) {
        list1.add(400);
        list1.add(500);
    }
    private void print(List<Integer> list) {
        for(Integer a: list) {
            System.out.print(a+" ");
        }
        System.out.println();
    }

    private void run() {
        List<Integer> list = new ArrayList<>();
        f1(list);
        print(list);

        f2(list);
        print(list);

        f3(list);
        print(list);


        stringTesting();
    }

    private void stringTesting() {
        String a = "hello";
        String b = "hello";
        String c = new String("hello");

        System.out.println("a equals b : "+(a==b));
        System.out.println("b equals c : "+(c==b));
        System.out.println("a.equals(b) : "+a.equals(b));
        System.out.println("b.equals(c): "+b.equals(c));

    }
}

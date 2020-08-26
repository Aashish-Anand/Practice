package Test1;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        new Sample().run();
    }

    private void run() {
        List<Integer> list = new ArrayList<>();

        for(Integer a : list){
            System.out.println(a);
        }


        b bbb = new b();
        System.out.println(bbb.i);
    }

    class A {
        int i = 0;
        A() {
            i = 1;
        }
    }
    class b extends A {
        public b() {
            i = 2;
        }
    }


}

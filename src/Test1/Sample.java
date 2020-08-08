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
    }
}

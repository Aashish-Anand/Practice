package PaajiTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Vm2 {
    public static void main(String[] args) {
        new Vm2().run();
    }
    private void run() {
        Optional a = Optional.of("Game of Thrones");
        String str[] = new String[10];
        Optional str1 = Optional.ofNullable(str[9]);

        System.out.println(str1.isPresent());
        System.out.println(a.isPresent());

        List ints = Arrays.asList(1,2);
        List nums = ints;
        nums.add(3.14);

    }
}

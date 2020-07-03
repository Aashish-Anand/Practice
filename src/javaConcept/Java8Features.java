package javaConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Features {
    public static void main(String[] args) {
        new Java8Features().run();
    }
    private void run() {
        String name = "my name is aashish";
        name = name.trim();


        String ans =
                Stream.of(name.split(" ")).map(ele -> (new StringBuffer(ele)).reverse().toString()).collect(Collectors.joining(" "));
        System.out.println(ans);

        // method 2
        ans =
                Arrays.asList(ans.split(" ")).stream().map(ele -> new StringBuffer(ele).reverse().toString()).collect(Collectors.joining(" "));

        System.out.println(ans);
    }
}

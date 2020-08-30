package javaConcept.Java8;

import java.security.SecureRandom;
import java.util.stream.Collectors;

public class MethodReference {
    public static void main(String[] args) {
        new MethodReference().run();
    }

    private void run() {
        SecureRandom random = new SecureRandom();

        random.ints(10, 1,7); // return intStream

        // print number on diffrent line
        random.ints(10, 1,7).forEach(System.out::println);  // objectName::instanceMethodName

        // System.out::println;   -> x -> System.out.println(x);

        System.out.println();

        // printing the number on the same line
        String number = random.ints(10, 1, 7)
                              .mapToObj(String::valueOf)
                              .collect(Collectors.joining(" "));

        System.out.println(number);
    }
}

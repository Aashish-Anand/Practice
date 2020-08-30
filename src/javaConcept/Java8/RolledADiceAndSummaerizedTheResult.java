package javaConcept.Java8;

import java.security.SecureRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RolledADiceAndSummaerizedTheResult {
    public static void main(String[] args) {
        new RolledADiceAndSummaerizedTheResult().run();
    }

    private void run() {
        // role a dice 60,000,000 times and summarized the result
        SecureRandom random = new SecureRandom();

        System.out.println("Face\t\t Frequency");
        random.ints(60_000_000,1,7).boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .forEach((face, frequency) ->
                        System.out.println(face+"\t\t\t "+frequency));
    }
}

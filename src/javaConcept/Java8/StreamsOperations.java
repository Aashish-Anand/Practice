package javaConcept.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamsOperations {
    public static void main(String[] args) {
        new StreamsOperations().run();
    }

    private void run() {
        streamInteger();
        streamString();
    }

    private void streamInteger() {
        Integer[] values = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};
        System.out.println("Array elements : " + Arrays.asList(values));

        System.out.println("Sorted value : " + Arrays.stream(values).sorted().collect(Collectors.toList()));

        List<Integer> greaterThan4 = Arrays.stream(values).filter(x -> x > 4).collect(Collectors.toList());
        System.out.println("Number greater than 4 : " + greaterThan4);

        System.out.println("Number greater than 4 and sorted : " + Arrays.stream(values).filter(x -> x > 4).sorted().collect(Collectors.toList()));

        System.out.println("Sorted Previously collected : " + greaterThan4.stream().sorted().collect(Collectors.toList()));
    }

    private void streamString() {
        String[] strings = {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

        // display original strings
        System.out.printf("Original strings: %s%n", Arrays.asList(strings));

        // strings in uppercase
        System.out.printf("strings in uppercase: %s%n",
                Arrays.stream(strings)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList()));

        // strings less than "n" (case insensitive) sorted ascending
        System.out.printf("strings less than n sorted ascending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("n") < 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER)
                        .collect(Collectors.toList()));

        // strings less than "n" (case insensitive) sorted descending
        System.out.printf("strings less than n sorted descending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("n") < 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                        .collect(Collectors.toList()));

    }
}

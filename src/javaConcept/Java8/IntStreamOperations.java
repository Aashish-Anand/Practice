package javaConcept.Java8;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamOperations {
    public static void main(String[] args) {
        new IntStreamOperations().run();
    }

    private void run() {
        int[] value = {3,10,6,1,4,8,2,5,9,7};

        System.out.println("Original value");
        System.out.println(IntStream.of(value).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        System.out.println("Count : "+IntStream.of(value).count());
        System.out.println("Max : "+IntStream.of(value).max().getAsInt());
        System.out.println("Min : "+IntStream.of(value).min().getAsInt());
        System.out.println("Sum : "+IntStream.of(value).sum());
        System.out.println("Average : "+IntStream.of(value).average().getAsDouble());

        System.out.println("Sum of value with reduced method : "+IntStream.of(value).reduce(0,(x,y)->x+y));

        System.out.println("Product of value with reduced method : "+IntStream.of(value).reduce((x,y)->x*y).getAsInt());

        System.out.println("Sum of squares via map and sum "+ IntStream.of(value).map(x->x*x).sum());

        System.out.println("Values displayed on sorted order : " + IntStream.of(value).sorted().mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}

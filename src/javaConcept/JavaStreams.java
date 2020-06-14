package javaConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams {
    public static void main(String[] args) {
        new JavaStreams().run();
    }

    private void run() {

        //Stream Intermediate Operation
        streamsIntermediateOperation();

        //Stream Terminal Operation
        streamsTerminalOperation();

    }

    private void streamsIntermediateOperation() {
        // 1. Map
        List<Integer> number = Arrays.asList(2,3,4,5);
        List<Integer> square = number.stream().map(x -> (x*x)).collect(Collectors.toList());
        square.forEach(x -> System.out.print(x +" "));

        System.out.println();
        // 2. filter
        List<String> listElement = Arrays.asList("Collections", "Streams","Integer", "Collects");
        List<String> filtered =
                listElement.stream().filter(x->x.startsWith("C")).collect(Collectors.toList());
        filtered.forEach(x-> System.out.print(x+" "));

        System.out.println();

        //3. sorted
        List<String> sorted = listElement.stream().sorted().collect(Collectors.toList());
        sorted.forEach(x -> System.out.print(x+" "));
    }

    private void streamsTerminalOperation() {
        System.out.println();
        //1.collect
        List<Integer> nums = Arrays.asList(1,3,4,5);
        List<Integer> collect = nums.stream().map(x -> x*x).collect(Collectors.toList());
        collect.forEach(x-> System.out.print(x+" "));

        System.out.println();
        //2. forEach
        collect.forEach(x-> System.out.print(x+" "));

        System.out.println();
        //3. reduce
        int even = nums.stream().filter(x->x%2==0).reduce(0, (ans,i)-> ans+i);
        System.out.println(even);

        HashSet<Integer>hash=new HashSet<>();
        hash.add(null);
        hash.forEach(x-> System.out.println(x));
    }
}

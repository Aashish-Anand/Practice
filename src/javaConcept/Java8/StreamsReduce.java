package javaConcept.Java8;

import java.sql.SQLOutput;
import java.util.stream.IntStream;

public class StreamsReduce {
    public static void main(String[] args) {
        new StreamsReduce().run();
    }

    private void run() {
        summing();
        mapReduce();
        filtering();
    }

    private void summing() {
        // simple for loop
        int total = 0;
        for(int i =1;i<=10;i++) {
            total += i;
        }
        System.out.println("Sum using for loop : "+total);

        // lets do it by IntStream
        System.out.println("Total using the IntStream : "+ IntStream.rangeClosed(1,10)
                                                                    .sum());

        // .sum is a reduction here
        IntStream.range(1,10);  // not include 10 in it
    }

    private void mapReduce(){
        System.out.println("sum : "+ IntStream.rangeClosed(1,10).map((int x)-> {return x*2;}).sum());

        //.map(x -> x*2)
        // this will convert every number to number*2 and sum them up
    }

    private void filtering() {
        //filtering on the basis of any conditions

        System.out.println(
                "Sum of triplets of the even integers from 2 to 10 is : "+
                        IntStream.rangeClosed(1,10)
                                 .filter(x -> x%2 == 0)
                                 .map(x -> x*3)
                                 .sum());
    }
}

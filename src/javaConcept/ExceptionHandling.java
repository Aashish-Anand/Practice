package javaConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExceptionHandling {
    public static void main(String[] args) {
        new ExceptionHandling().run();
    }

    private void run() {

        // first we check using throw
//        System.out.println(returnException());
//
//        //now we using throws
//        System.out.println(returnException2());

        List<Integer> ll = new ArrayList<>();

        ll.add(1);
        ll.add(2);
        ll.add(6);
        ll.stream().filter(a -> a%2==0).forEach(System.out::println);

        List<String> ll1 = new ArrayList<>();
        ll1.stream().filter((s) -> s.startsWith("A"))
                .map(String::toUpperCase).collect(Collectors.toList());


        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

        List<Integer> listOfAllIntegers = listOfLists.stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
    }

    private int returnException() {
        String abc = null;

        try{
            int len = abc.length();
            return 20;
        }
        catch (NullPointerException e){
            System.out.println("Found NPE");
            //return 5;
            //System.out.println("hahahahha");
            //throw new NullPointerException();
        }
        finally {
            System.out.println("Inside finally");
        }
        return 10;
    }

    private int returnException2() throws NullPointerException{

        String s = null;
        int len = s.length();
        System.out.println("We are using throws");
        return len;
    }
}

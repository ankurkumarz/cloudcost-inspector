package com.ps.cloudcostinspector.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    // check for Terminal or Intermediate operation
    // check whether output is another Stream or Value

    //Collector used to change streams to collection

    ArrayList<String> names = new ArrayList<>();

    public static void main(String[] args) {
        Streams s = new Streams();
        ArrayList<String> names = s.names;
        names.add("ankur");
        names.add("ritika");
        names.add("trisha");
        names.add("anusha");
        System.out.println(s.names);

        s.names.stream()
                .filter(p -> p.equalsIgnoreCase("ankur"))
                .forEach(a -> System.out.println(a));

        ArrayList<Integer> myints = new ArrayList<>();
        myints.add(12);
        myints.add(16);
        myints.add(1);

        Optional<Integer> result = myints.stream().max(Integer::compare);
        System.out.println(result);

        System.out.println(myints.stream().filter(a -> a > 2).collect(Collectors.toList()));

        //reduce function producing another stream
        System.out.println(myints.stream().reduce((a,b) -> a*b));

        // for changing one stream to another
        myints.stream().map(a -> Math.sqrt(a)).forEach(System.out::println);

        //to map the elements of one stream to another
        myints.stream().map(a -> {
           return String.valueOf(a);
        });

    }


    private static boolean lookupValue(List<String> values, String lookupValue) {
        boolean found = false;
        values.forEach(n -> n.equalsIgnoreCase(lookupValue));
        return found;
    }
    private static Optional<Integer> sumUsingStream(int loopLength) {
        Stream<Integer> integers = Stream.iterate(0, i -> i+1);
        return integers.limit(loopLength).reduce(Integer::sum);
    }
    private static void whileLoopWithStream(int loopLength) {
        Stream<Integer> integers = Stream.iterate(0, i -> i+1);
        integers.limit(10).forEach(System.out::println);
    }
    private static String getLastElementUsingReduce(List<String> values) {
        return values.stream().reduce((first, second) -> second).orElse(null);
    }
}

package com.ps.cloudcostinspector.examples;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

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

}

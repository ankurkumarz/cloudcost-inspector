package com.ps.cloudcostinspector.examples;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;
public class Lambda {

    public static void main(String[] args) {
        Consumer tt = (n) -> System.out.println("hellow " + n);
        Supplier ss ;
        ArrayList<String> mylist = new ArrayList<>();
        mylist.add("ankur");
        mylist.add("kumar");
        mylist.stream().forEach(tt);
    }
}

package com.ps.cloudcostinspector.examples.records;

/*
Records cannot extend any class
Records cannot declare instance fields (other than the private final fields that correspond to the components of the record component list); any other declared fields must be static
Records cannot be abstract; they are implicitly final
The components of a record are implicitly final
 */
public record Person (String name, int age, String address) {
    public static String UNKNOWN_ADDRESS = "Unknown";

    // compact constructors to ensure not null
    public Person {
        java.util.Objects.nonNull(name);
    }

    // constructor for limited fields
    public Person (String name, int age) {
        this (name, age, UNKNOWN_ADDRESS);
    }
}

class Main {
    public static void main(String[] args) {
        Person p = new Person("ankur", 41, "torrance");
        Person p2 = new Person("ankur", 41);
        System.out.println(p.toString() +  p2.toString());
    }
}

package com.ps.cloudcostinspector.examples;

public class GenericBounded<T extends Number> {

    T obj;

    public void setVal(T value) {
        this.obj = value;
    }
    public T getVal() {
        return obj;
    }

    public static void main(String[] args) {
        GenericBounded<Integer> obj = new GenericBounded<Integer>();
        obj.setVal(12);
        
        // will not work because of bounded context
        // GenericBounded<String> obj2 = new GenericBounded<>();
    }
}

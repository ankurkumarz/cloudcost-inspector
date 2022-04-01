package com.ps.cloudcostinspector.domain.generics;

public class GenericsTest {

    public static void main(String[] args) throws Exception {
        Cache<String, Object> cache = new Cache<String, Object>();
        cache.add("te", "te");
        System.out.println(cache.getValue());
    }
}

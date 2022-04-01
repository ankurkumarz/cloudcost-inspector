package com.ps.cloudcostinspector.examples;

public class Generic<A> {
    A obj;

    public Generic(A obj) {
        this.obj = obj;
    }
    public A getObj() {
        return obj;
    }
}

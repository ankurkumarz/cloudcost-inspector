package com.ps.cloudcostinspector.domain.generics;

import java.util.HashMap;
import java.util.Map;

public class Cache<K,V> {
    K key;
    V value;
    Map<K,V> cache;

    public Cache() {
        cache = new HashMap<K,V>();
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public boolean add(K key2, V value2) {
        cache.put(key, value);
        key = key2;
        value = value2;
        return true;
    }
}

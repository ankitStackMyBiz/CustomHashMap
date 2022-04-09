package com.example.helloworld;

import java.util.Map;

public class EntryClass<K,V> implements Map.Entry {

    private K key;
    private V value;
    private EntryClass<K,V> next;

    public EntryClass(K key, V value, EntryClass<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public Object setValue(Object value) {
        this.value = (V) value;
        return null;
    }

//    public void setValue(V value) {
//        this.value = value;
//    }

    public EntryClass<K, V> getNext() {
        return next;
    }

    public void setNext(EntryClass<K, V> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "EntryClass{" +
                "key=" + key +
                ", value=" + value +
                ", next=" + next +
                '}';
    }
}

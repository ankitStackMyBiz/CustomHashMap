package com.example.helloworld;

public class EntryClass<K,V> {

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

    public void setValue(V value) {
        this.value = value;
    }

    public EntryClass<K, V> getNext() {
        return next;
    }

    public void setNext(EntryClass<K, V> next) {
        this.next = next;
    }
}

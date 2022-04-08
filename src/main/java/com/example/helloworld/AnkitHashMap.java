package com.example.helloworld;

import java.util.*;

public class AnkitHashMap<K, V> implements Map<K, V> {

    private int initialCapacity = 5;
    private EntryClass<K, V>[] table;


    private int getHash(Object key) {
        if (null != key) {
            return key.hashCode() % initialCapacity;
        } else {
            return 0;
        }
    }

    public void iterateUsingForLoopEntrySet(Map<K,V> map){

        for(Entry<K,V> entry : map.entrySet()){
            if(entry != null) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }

    }




    public AnkitHashMap() {
        this.table = new EntryClass[initialCapacity];
    }


    @Override
    public V put(K newKey, V newValue) {
        int hash = getHash(newKey);
        EntryClass<K, V> entry = table[hash];
        if (entry == null) {
            table[hash] = new EntryClass<>(newKey, newValue, null);
            return newValue;
        } else {
            //traverse through linked list and check if next is null
            while (entry.getNext() != null) {
                //check for each entry and match the key
                if (entry.getKey() == newKey) {
                    //key matches
                    //set and return
                    entry.setValue(newValue);
                    return newValue;
                }
                //key doesn't match create a new entry
                entry = entry.getNext();
            }

            //reached last entry and next is null
            // key matches update the value
            if (entry.getKey() == newKey) {
                entry.setValue(newValue);
                return newValue;
            }

            //key doesn't match
            //create new entry
            entry.setNext(new EntryClass<>(newKey, newValue, null));
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        int hash = getHash(key);
        EntryClass<K, V> entry = table[hash];

        //entry is not there
        if (entry == null) {
            return null;
        }

        //if entry key matches with key provided
        if (entry.getKey() == key) {
            //removing here
            //point the head to next entry
            table[hash] = entry.getNext();
            entry.setNext(null);
            return entry.getValue();
        }

        EntryClass<K, V> previousEntry = entry;
        entry = entry.getNext();

        //
        while (entry != null) {
            if (entry.getKey() == key) {
                //removing here
                //point the head to next entry
                previousEntry.setNext(entry.getNext());
                entry.setNext(null);
                return entry.getValue();
            }
            previousEntry = entry;
            entry = entry.getNext();

        }
        return null;
    }


    @Override
    public V get(Object key) {
        int index = getHash(key);
        EntryClass<K, V> entry = table[index];
        if (entry == null) {
            //noting in the list
            return null;
        }

        while (entry != null) {
            if (entry.getKey() == key) {
                return entry.getValue();
            }
            entry = entry.getNext();
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {

        int hash = getHash(key);
        EntryClass<K, V> entry = table[hash];
        if (entry == null) {
            return false;
        }
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return true;
            }
            entry = entry.getNext();
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {

        if (null != table) {
            for (int i = 0; i < table.length; i++) {
                EntryClass<K, V> entry = table[i];
                if (null != entry && table[i].getValue() == value) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < initialCapacity; i++) {
            if (table[i] != null) {
                sb.append(i).append(" ").append(table[i].getKey()).append(" : ").append(table[i].getValue()).append("\n");
            } else {
                sb.append(i).append(" ").append("null").append("\n");
            }
        }

        return sb.toString();
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {

        return false;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }


    //TODO - Implement keySet(), values() and entrySet() to support iteration
    // @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<>();

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
            }
        }
        return entrySet;

    }

}

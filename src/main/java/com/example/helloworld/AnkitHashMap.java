package com.example.helloworld;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class AnkitHashMap<K, V> implements Map<K, V>, Iterable<EntryClass>, Iterator {

    private int initialCapacity = 5;
    private EntryClass<K, V>[] table;


    private int getHash(Object key) {
        if (null != key) {
            return key.hashCode() % initialCapacity;
        } else {
            return 0;
        }
    }

    public void iterateUsingForLoopEntrySet(Map<K, V> map) {

        for (Entry<K, V> entry : map.entrySet()) {
            if (entry != null) {
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

    @Override
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        Arrays.stream(table).forEach(entry -> {
            if (entry != null) {
                if (entry.getNext() == null) {
                    keySet.add(entry.getKey());
                } else {
                    keySet.add(entry.getKey());
                    while (entry.getNext() != null){
                        keySet.add(entry.getNext().getKey());
                        entry = entry.getNext();
                    }
                }
            }
        });

        return keySet;
    }

    @Override
    public Collection<V> values() {
        Collection<V> valueSet = new HashSet<>();
        Arrays.stream(table).forEach(entry -> {
            if (entry != null) {
                if (entry.getNext() == null) {
                    valueSet.add(entry.getValue());
                } else {
                    valueSet.add(entry.getValue());
                    while (entry.getNext() != null){
                        valueSet.add(entry.getNext().getValue());
                        entry = entry.getNext();
                    }
                }
            }
        });
        return valueSet;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<>();
        Arrays.stream(table).forEach(entry -> {
            System.out.println(": " + entry);
            if (entry != null) {

                if (entry.getNext() == null) {
                    entrySet.add(new EntryClass<>(entry.getKey(), entry.getValue(), null));
                } else {
                    entrySet.add(new EntryClass<>(entry.getKey(), entry.getValue(), null));
                    while (entry.getNext() != null){
                        entrySet.add(new EntryClass<>(entry.getNext().getKey(), entry.getNext().getValue(), null));
                        entry = entry.getNext();
                    }
                }
            }
        });

        return entrySet;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return Map.super.getOrDefault(key, defaultValue);
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {
        Map.super.forEach(action);
    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        Map.super.replaceAll(function);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        return Map.super.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return Map.super.remove(key, value);
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return Map.super.replace(key, oldValue, newValue);
    }

    @Override
    public V replace(K key, V value) {
        return Map.super.replace(key, value);
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return Map.super.computeIfAbsent(key, mappingFunction);
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return Map.super.computeIfPresent(key, remappingFunction);
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return Map.super.compute(key, remappingFunction);
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return Map.super.merge(key, value, remappingFunction);
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}

package com.example.helloworld;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapRunnerClass {


    public static void main(String[] args) {
        AnkitHashMap<Integer, String> ankitHashMap = new AnkitHashMap<>();

        ankitHashMap.put(8, "Ankit");
        ankitHashMap.put(2, "Rakesh");
        ankitHashMap.put(4, "Jji");
        ankitHashMap.put(null, "Ritesh");


        System.out.println("\nIterating through hashmap using forEach :::::::::\n");
        //iterate through hashmap using foreach loop
        for (Map.Entry<Integer, String> entry : ankitHashMap.entrySet()) {
            System.out.println(entry);
        }

        //key
        for (Integer key : ankitHashMap.keySet()) {
            System.out.println(key);
        }

        //values
        for (String value : ankitHashMap.values()) {
            System.out.println(value);
        }


        //***************************

        //iterate through hashmap using iterator

        System.out.println("\nIterating through hashmap using iterator :::::::::\n");
        //entrySet
        Iterator<Map.Entry<Integer,String>> entryIterator = ankitHashMap.entrySet().iterator();

        while (entryIterator.hasNext()){
            System.out.println(entryIterator.next());
        }

        //keySet
        Iterator<Integer> keySet =  ankitHashMap.keySet().iterator();
        while (keySet.hasNext()){
            System.out.println(keySet.next());
        }

        //values
        Iterator<String> valueSet = ankitHashMap.values().iterator();
        while (valueSet.hasNext()){
            System.out.println(valueSet.next());
        }

        //***************************

        //iterate through forEach and lambda
        System.out.println("\nIterating through hashmap using forEach and lambda :::::::::\n");

        //entry set
        ankitHashMap.entrySet().forEach(entry -> {
            System.out.println(entry);
        });

        //keySet

        ankitHashMap.keySet().forEach(key ->{
            System.out.println(key);
        });

        //values
        ankitHashMap.values().forEach(value ->{
            System.out.println(value);
        });


        //***************************

        //iterate through forEach and lambda
        System.out.println("\nIterating through hashmap using stream :::::::::\n");

        ankitHashMap.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey()+":"+entry.getValue());
        });


    }
}

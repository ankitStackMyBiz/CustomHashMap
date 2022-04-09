package com.example.helloworld;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExercise {


    public static void main(String[] args) {
        AnkitHashMap<String, Integer> carHashMap = new AnkitHashMap<>();

        carHashMap.put("Audi", 2);
        carHashMap.put("BMW", 5);
        carHashMap.put("Maruti", 4);
        carHashMap.put("Suzuki", 7);
        carHashMap.put("Aston", 1);
        carHashMap.put("apple", 0);

        filterMap(carHashMap);


        AnkitHashMap<String, Integer> fruits = new AnkitHashMap<>();

        fruits.put("Apple", 200);
        fruits.put("apple", 80);
        fruits.put("Mango", 40);
        fruits.put("angoor", 70);
        fruits.put("Melon", 10);
        fruits.put("Grapes", 100);

        filterMap(fruits);

    }

    private static void filterMap(AnkitHashMap<String, Integer> hashMap) {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("\n\nkeySet : "+hashMap.keySet());
        System.out.println("valueSet : "+hashMap.values());


        //Using stream to iterate and remove the entries starting with "a"
        System.out.println("\nAfter applying filter the hashmap - key starts with 'a' will be filtered out :: ");

        //list
        List<String> filteredList = hashMap.keySet().stream()
                .filter(e -> e.startsWith("a"))
                .collect(Collectors.toList());

        System.out.println("Filtered out with key starts with 'a'  : "+filteredList);
    }


}

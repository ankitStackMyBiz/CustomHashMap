package com.example.helloworld;

public class StreamExercise {


    public static void main(String[] args) {
        AnkitHashMap<String, Integer> carHashMap = new AnkitHashMap<>();

        carHashMap.put("Audi", 2);
        carHashMap.put("BMW", 5);
        carHashMap.put("Maruti", 4);
        carHashMap.put("Suzuki", 5);
        carHashMap.put("Aston", 1);
        carHashMap.put("apple", 0);


       // System.out.println(carHashMap);

        //System.out.println(carHashMap.entrySet());
        System.out.println(carHashMap.keySet());
        System.out.println(carHashMap.values());
        //Using stream to iterate and remove the entries starting with "a"

        System.out.println("After delete(key starts with a : " );
        carHashMap.keySet().stream().forEach(k -> {
            if(k.startsWith("a")){
                carHashMap.remove(k);
            }
        });

        System.out.println(carHashMap.keySet());
    }


}

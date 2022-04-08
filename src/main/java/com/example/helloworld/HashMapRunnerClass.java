package com.example.helloworld;

import java.util.HashMap;
import java.util.Map;

public class HashMapRunnerClass {


    public static void main(String[] args) {
        AnkitHashMap<Integer, String> ankitHashMap = new AnkitHashMap<>();


        ankitHashMap.put(null, "Ankit");
        //System.out.println(ankitHashMap);


//        HashMap<String,String> hashMap = new HashMap<>(6);
//
//        hashMap.put("Ankit","Male");
//        hashMap.put("Rakesh","Male");
//        hashMap.put("Amit","Male");
//
//        for(Map.Entry<String,String> entry : hashMap.entrySet()){
//            if(entry != null) {
//                System.out.println(entry.getKey() + " : " + entry.getValue());
//            }
//        }




        ankitHashMap.put(3, "Ankit");
        ankitHashMap.put(2, "Rakesh");
        ankitHashMap.put(null, "Rakesh");
        ankitHashMap.put(null, "Ritesh");

        System.out.println(ankitHashMap);

        ankitHashMap.remove(1);
        System.out.println(ankitHashMap);
        ankitHashMap.remove(1);

        System.out.println(ankitHashMap.containsKey(2));
        System.out.println(ankitHashMap.containsValue("Rakesh"));
        System.out.println(ankitHashMap.containsValue("Mukesh"));
        System.out.println(ankitHashMap.containsValue(null));
        System.out.println(ankitHashMap.get(null));
        System.out.println(ankitHashMap.get(2));

//        AnkitHashMap<String, String> myHashMap = new AnkitHashMap<String, String>();
//        myHashMap.put("A", "B");
//        myHashMap.put("E", "F");
//        myHashMap.put("H", "P");
//        myHashMap.put("P", "2");
//        myHashMap.put("1",  "G");
//        myHashMap.put("2", "6");
//        myHashMap.put("3", "2");
//        myHashMap.put("4", "4");
//        myHashMap.put("1",  "H");


//    System.out.println(myHashMap);
////    System.out.println(myHashMap.get("A"));
////    System.out.println(myHashMap.remove("A"));
//        myHashMap.remove("2");
//        System.out.println(myHashMap.get(3));
//    }

    }
}

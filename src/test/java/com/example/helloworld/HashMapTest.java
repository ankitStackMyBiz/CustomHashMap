package com.example.helloworld;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HashMapTest {

    @Test
    @DisplayName("Should pass if new entry gets inserted in hashmap properly and value is matched as given")
    void putHasMapTestNewEntry() {
        AnkitHashMap<Integer, String> ankitHashMap = new AnkitHashMap<>();
        String value = ankitHashMap.put(1, "Ankit");
        assertEquals("Ankit", value);
    }

    @Test
    @DisplayName("Should pass if duplicates entry are provided")
    void putHasMapTestDuplicateEntry() {
        AnkitHashMap<Integer, String> ankitHashMap = new AnkitHashMap<>();
        String entryValue = ankitHashMap.put(1, "Ankit");
        String anotherEntry = ankitHashMap.put(1, "Mukesh");
        assertEquals("Ankit", entryValue);
        assertEquals("Mukesh", anotherEntry);
    }

    @Test
    @DisplayName("Should pass if one null key is provided")
    void putHasMapTestOneNullKey() {
        AnkitHashMap<String, String> ankitHashMap = new AnkitHashMap<>();
        String entryValue = ankitHashMap.put(null, "Ankit");
        assertEquals("Ankit", entryValue);
    }

    @Test
    @DisplayName("Should pass if one null key is provided")
    void putHasMapTestTwoNullKey() {
        AnkitHashMap<String, String> ankitHashMap = new AnkitHashMap<>();
        String entryValue = ankitHashMap.put(null, "Ankit");
        String anotherEntry = ankitHashMap.put(null, "Mukesh");
        assertEquals("Ankit", entryValue);
        assertEquals("Mukesh", anotherEntry);
    }

    @Test
    @DisplayName("Should pass if one null key is provided")
    void putHasMapTestNullValue() {
        AnkitHashMap<String, String> ankitHashMap = new AnkitHashMap<>();
        String entryValue = ankitHashMap.put("1", null);
        assertNull(entryValue);
    }

    @Test
    @DisplayName("Should pass if got value with after putting entry into the hashMap ")
    void getHashMapTestWithKey(){
        AnkitHashMap<Integer, String> ankitHashMap = new AnkitHashMap<>();
        ankitHashMap.put(1, "Ankit");
        ankitHashMap.put(2, "Mukesh");
        assertEquals("Ankit", ankitHashMap.get(1));
        assertEquals("Mukesh", ankitHashMap.get(2));
    }

    @Test
    @DisplayName("Should pass if null key is provided ")
    void getHashMapTestWithKeyNull(){
        AnkitHashMap<Integer, String> ankitHashMap = new AnkitHashMap<>();
        ankitHashMap.put(null, "Ankit");
        assertEquals("Ankit", ankitHashMap.get(null));
    }

    /*
    * TODO More test cases to find more cases and errors
    * */


}

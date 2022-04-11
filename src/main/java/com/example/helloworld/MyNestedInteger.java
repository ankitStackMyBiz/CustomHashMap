package com.example.helloworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class MyNestedInteger implements NestedInteger {
    private List<NestedInteger> list;
    private Integer integer;

    public MyNestedInteger(Integer integer) {
        this.integer = integer;
    }

    public MyNestedInteger(List<NestedInteger> nestedList) {
        this.list = nestedList;
    }


    @Override
    public boolean isInteger() {
        if (integer != null) {
            return true;
        }
        return false;
    }

    @Override
    public Integer getInteger() {
        return integer;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }

    @Override
    public String toString() {
        if (isInteger()) {
            return String.valueOf(integer);
        } else {
            return getList().toString();
        }
    }


    public static void main(String[] args) {

        /*
         *
         * Sample -> [[1,2], 2, 3, [3,4]]
         *
         * o3 = ni(3)
         * o4 = ni(4)
         * o1 = ni(1)
         * o2 = ni(2)
         * o34 = ni([o3,o4])
         * o12 = ni([o1,o2])
         *
         * O = ni([o12, o2, o3, o34])
         *
         * */


        MyNestedInteger o3 = new MyNestedInteger(3);
        MyNestedInteger o4 = new MyNestedInteger(4);
        MyNestedInteger o1 = new MyNestedInteger(1);
        MyNestedInteger o2 = new MyNestedInteger(2);
        MyNestedInteger o34 = new MyNestedInteger(Arrays.asList(o3, o4));
        MyNestedInteger o12 = new MyNestedInteger(Arrays.asList(o1, o2));

        MyNestedInteger o = new MyNestedInteger(Arrays.asList(o12, o2, o3, o34));
        System.out.println(o);
    }
}

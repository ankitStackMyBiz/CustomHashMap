package com.example.helloworld;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedIterator implements Iterator<Integer> {

    private Queue<Integer> integerQueue;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.integerQueue = new LinkedList<>();
        addEntries(nestedList);
    }

    private void addEntries(List<NestedInteger> nestedList) {
        for(NestedInteger nestedInteger : nestedList){
            if(nestedInteger.isInteger()){
                integerQueue.add(nestedInteger.getInteger());
            }else{
                addEntries(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if(!integerQueue.isEmpty()){
            return integerQueue.poll();
        }else{
            return -1;
        }
    }

    @Override
    public boolean hasNext() {
       return !integerQueue.isEmpty();
    }
}
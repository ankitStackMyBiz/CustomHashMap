package com.example.helloworld;

import java.util.*;
import java.util.stream.IntStream;

class PeekingIterator<K> implements Iterator<K> {

    private Iterator<K> iterator;
    private K nextValue;
    private K integer;
    List<K> kList;

    public PeekingIterator(Iterator<K> iterator) {
        // initialize any member here.
        kList = new ArrayList<>();
        this.iterator = iterator;
        if (iterator.hasNext()) {
            nextValue = iterator.next();
        }

    }


    // Returns the next element in the iteration without advancing the iterator.
    public K peek() {
        System.out.println(nextValue);
        return nextValue;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public K next() {
        K temp = nextValue;
        if (iterator.hasNext()) {
            nextValue = iterator.next();
        } else {
            nextValue = null;
        }
        System.out.println(temp);
        return temp;

    }

    @Override
    public boolean hasNext() {
        boolean hashNextOrNot = nextValue != null || iterator.hasNext();
        System.out.println(hashNextOrNot);
        return hashNextOrNot;
    }


//    @Override
//    public String toString() {
//        return getListToPrint().toString();
//    }

//    private void setList(K op) {
//        kList.add(op);
//    }
//
//    private List<K> getListToPrint() {
//        return kList;
//    }


    public static void main(String[] args) {

        int first = 1;
        int count = 3;
        Iterator<Integer> it = IntStream.range(first, first + count).iterator();


        PeekingIterator peekingIterator = new PeekingIterator(it); // [1,2,3]


        int n = (int) peekingIterator.next();    // return 1, the pointer moves to the next element [1,2,3].
        peekingIterator.peek();    // return 2, the pointer does not move [1,2,3].
        peekingIterator.next();    // return 2, the pointer moves to the next element [1,2,3]
        peekingIterator.next();    // return 3, the pointer moves to the next element [1,2,3]
        peekingIterator.hasNext(); //





//        int n = (int) peekingIterator.next();    // return 1, the pointer moves to the next element [1,2,3].
//        Integer n1 = (Integer) peekingIterator.peek();    // return 2, the pointer does not move [1,2,3].
//        Integer n2 = (Integer) peekingIterator.next();    // return 2, the pointer moves to the next element [1,2,3]
//        Integer n3 = (Integer) peekingIterator.next();    // return 3, the pointer moves to the next element [1,2,3]
//        Boolean b = peekingIterator.hasNext(); //


        //add in a list and print output
//        peekingIterator.setList(n);
//        peekingIterator.setList(n1);
//        peekingIterator.setList(n2);
//        peekingIterator.setList(n3);
//        peekingIterator.setList(b);
//
//        System.out.println(peekingIterator);


    }


    /*@Override
    public Iterator<K> iterator() {
        Iterator<K> it = new Iterator<K>() {


            @Override
            public boolean hasNext() {

            }

            @Override
            public K next() {

            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }*/
}

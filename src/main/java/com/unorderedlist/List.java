package com.unorderedlist;

public class List <E> {

    public E first;
    public E last;
    public int count;

    public List() {
        first = null;
        last = null;
        count = 0;
    }

    class Node {
        E data;
        List next;
    }

}

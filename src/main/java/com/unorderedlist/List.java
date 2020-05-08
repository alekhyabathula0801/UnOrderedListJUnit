package com.unorderedlist;

public class List <E> {

    public Node first;
    public Node last;
    public int count;

    public List() {
        first = null;
        last = null;
        count = 0;
    }

    class Node <E> {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public <E> void add(E item) throws ListException {
        try {
            if(item == "")
                throw new ListException("Entered Empty");
            Node newNode = new Node(item);
            newNode.next = null;

            if (first == null) {
                first = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
            count++;
        } catch (NullPointerException e) {
            throw new ListException("Entered Null");
        }
    }

    public <E> void remove(E item) throws ListException {
        try {
            if(item == "")
                throw new ListException("Entered Empty");
            Node temp = first;
            if (first.data == item) {
                first = first.next;
                count--;
            } else {
                for(temp=first;temp.next.data != item; temp=temp.next);
                temp.next = temp.next.next;
                count--;
            }
        } catch (NullPointerException e) {
            throw new ListException("Entered Null");
        }
    }
}

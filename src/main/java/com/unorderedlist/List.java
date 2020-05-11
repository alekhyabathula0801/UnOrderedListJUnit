package com.unorderedlist;

public class List<E extends Comparable> {

    public Node head;
    public Node tail;
    public Node currentNode;
    public int count;

    public List() {
        head = null;
        tail = null;
        count = 0;
    }

    class Node <E extends Comparable> {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    public <E extends Comparable> void add(E item) throws ListException {
        try {
            if(item == "")
                throw new ListException("Entered Empty");
            Node newNode = new Node(item);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            tail.next = null;
            count++;
        } catch (NullPointerException e) {
            throw new ListException("Entered Null");
        }
    }

    public <E extends Comparable> void remove(E item) throws ListException {
        try {
            if(item == "")
                throw new ListException("Entered Empty");
            else if (head.data == item) {
                head = head.next;
                count--;
            } else if(tail.data==item){
                for(currentNode = head; item.compareTo(currentNode.next.data) != 0; currentNode = currentNode.next);
                tail = currentNode;
                tail.next = null;
                count--;
            } else if(search(item)){
                for(currentNode = head; item.compareTo(currentNode.next.data) != 0 ; currentNode = currentNode.next);
                currentNode.next = currentNode.next.next;
                count--;
            } else
                throw new ListException("Element entered is not found in list");

        } catch (NullPointerException e) {
            throw new ListException("Entered Null");
        }
    }

    public <E extends Comparable> Boolean search(E item) throws ListException {
        if(index(item) == -1)
            return false;
        else
            return true;
    }

    public <E> Boolean isEmpty() {
        if(head == null)
            return true;
        return false;
    }

    public <E> int size() {
        return count;
    }

    public <E extends Comparable> void append(E ...values) throws ListException {
        for(E value : values)
            add(value);
    }

    public <E extends Comparable> int index(E item) throws ListException {
        int index = -1;
        try {
            if(item == "")
                throw new ListException("Entered Empty");
            else {
                for (currentNode = head; currentNode != null; currentNode = currentNode.next) {
                    index++;
                    if(item.compareTo(currentNode.data) == 0 )
                        return index;
                }
                return -1;
            }
        } catch (NullPointerException e) {
            throw new ListException("Entered Null");
        }
    }

    public void pop() throws ListException {
        remove(tail.data);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        currentNode = head;
        while ( currentNode.next != null) {
            builder.append(currentNode.data).append(",");
            currentNode = currentNode.next;
        }
        builder.append(currentNode.data);
        return builder+"";
    }

}

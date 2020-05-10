package com.unorderedlist;

public class SinglyLinkedList<E> {

    public Node first;
    public Node last;
    public Node temp;
    public int count;

    public SinglyLinkedList() {
        first = null;
        last = null;
        count = 0;
    }

    class Node <E> {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    public <E> void add(E item) throws ListException {
        try {
            if(item == "")
                throw new ListException("Entered Empty");
            Node newNode = new Node(item);
            if (first == null) {
                first = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
            last.next = null;
            count++;
        } catch (NullPointerException e) {
            throw new ListException("Entered Null");
        }
    }

    public <E> void remove(E item) throws ListException {
        try {
            if(item == "")
                throw new ListException("Entered Empty");
            else if (first.data == item) {
                first = first.next;
                count--;
            } else if(last.data==item){
                for(temp=first;temp.next.next != null; temp=temp.next);
                last = temp;
                last.next = null;
                count--;
            } else if(search(item)){
                for(temp=first ;temp.next.data != item ; temp=temp.next);
                    temp.next = temp.next.next;
                    count--;
            } else
                System.out.println("Element entered is not found in list");
        } catch (NullPointerException e) {
            throw new ListException("Entered Null");
        }
    }

    public <E> Boolean search(E item) throws ListException {
        try {
            if(item == "")
                throw new ListException("Entered Empty");
            for(temp=first; temp != null; temp=temp.next) {
                if (item.equals(temp.data))
                    return true;
            }
            return false;
        } catch (NullPointerException e) {
            throw new ListException("Entered Null");
        }
    }

    public <E> Boolean isEmpty() {
        if(count == 0)
            return true;
        return false;
    }

    public <E> int size() {
        return count;
    }

    public <E> void displayList(){
        for(temp=first;temp!=null;temp=temp.next){
            System.out.println(temp.data);
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        temp = first;
        while ( temp.next != null) {
            builder.append(temp.data).append(",");
            temp = temp.next;
        }
        builder.append(temp.data);
        return builder+"";
    }

}

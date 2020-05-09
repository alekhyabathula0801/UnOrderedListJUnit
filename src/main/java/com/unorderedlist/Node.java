package com.unorderedlist;

public class Node <E>{
        private E value;
        private Node<E> next;

        public Node(E value) {
            this(value,null);
        }

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", NextNode=" + next +
                    '}';
        }
}

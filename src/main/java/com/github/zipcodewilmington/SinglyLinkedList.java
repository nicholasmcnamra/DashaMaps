package com.github.zipcodewilmington;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {

    public class Node {
        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node first;
    private Node last;
    private int N;


    public SinglyLinkedList() {
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(String key, int value) {
        Node item = new Node(key, value);
        if (item == null) {throw new NullPointerException();}
        if (!isEmpty()) {
            Node previous = last;
            last = item;
            previous.next = last;
        }
        else {
            last = item;
            first = last;
        }
        N++;
    }

    public boolean remove(String key) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty. Nothing to remove.");
        }
        boolean result = false;
        Node current = first;
        Node previous = first;
        try {
            while (current.next != null || current == last) {
                if (current.key.equals(key)) {
                    if (N == 1) {
                        first = null;
                        last = null;
                    }
                    //remove 1st element
                    else if (current.equals(first)) {
                        first = first.next;
                    }
                    //remove last
                    else if (current.equals(last)) {
                        previous = last;
                        last.next = null;
                    }
                    //look for element and remove it
                    else {
                        previous.next = current.next;
                    }
                    N--;
                    result = true;
                }
                previous = current;
                current = previous.next;
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught");
        }
        return result;
    }

    public boolean contains(String key) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty. Nothing to check.");
        }
        boolean result = false;
        Node current = first;
        while (current.next != null || current == last) {
            if (current.key.equals(key)) {
                result = true;
                break;
            }
            else {
                current = current.next;
            }
        }
        return result;
    }

    public int find(String key) {
        int result = -1;
        Node current = first;
        while (current.next != null || current == last) {
            if (current.key.equals(key)) {
                result++;
                break;
            } else {
                result++;
                current = current.next;
            }
        }
        return result;
    }

    public Node get(int index) {
        Node result = null;
        Node current = first;
        for (int i = 0; i < N; i++) {
            if (i == index) {
                result = current;
            } else {
                current = current.next;
            }
        }
        return result;
    }

//    public SinglyLinkedList<T> copy() {
//        SinglyLinkedList<T> newList  = new SinglyLinkedList<>();
//
//        Node current = first;
//        while (current != null || current == last) {
//            newList.add(current.data);
//            current = current.next;
//        }
//
//        return newList;
//    }
//
//    public void intSort() {
//        try {
//            Node current = first;
//            Node index;
//
//            T temp;
//
//            if (first == null) {
//                throw new IllegalStateException("List is empty. Nothing to sort.");
//            } else {
//                while (current != null) {
//                    index = current.next;
//
//                    while (index != null) {
//                        if ((int) current.data > (int) index.data) {
//                            temp = current.data;
//                            current.data = index.data;
//                            index.data = temp;
//                        }
//                        index = index.next;
//                    }
//                    current = current.next;
//                }
//            }
//
//        } catch (NullPointerException e) {
//            System.out.println("NullPointerException caught");
//        }
//    }

}
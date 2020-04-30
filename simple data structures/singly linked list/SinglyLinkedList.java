package com.company;

public abstract class SinglyLinkedList {
    protected Link first;

    public abstract void insertFirst(int value);
    public abstract Link deleteFirst();

    public boolean isEmpty() {
        return first == null;
    }

    public Link find(int value) {
        Link current = first;
        while(current.iData != value) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public void displayList() {
        Link current = first;
        while(current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}

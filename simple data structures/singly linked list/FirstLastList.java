package com.company;
/*
    Singly linked list with pointer to first element and last.
    Accelerate addition to the end of the list
 */
public class FirstLastList extends SinglyLinkedList {
    private Link last;

    public void insertFirst(int value) {
        Link link = new Link(value);
        if (isEmpty())
            last = link;
        link.next = first;
        first = link;
    }

    public void insertLast(int value) {
        Link link = new Link(value);
        if (isEmpty())
            first = link;
        else
            last.next = link;
        last = link;
    }

    public Link deleteFirst() {
        Link temp = first;
        if(first.next == null)
            last = null;
        first = first.next;
        return temp;
    }
}

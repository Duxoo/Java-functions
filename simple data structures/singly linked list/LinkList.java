package com.company;
/*
    Singly linked list with pointer to the first link of the list
 */
public class LinkList extends SinglyLinkedList {

    public void insertFirst(int value) {
        Link newLink = new Link(value);
        newLink.next = first; // newLink --> old value of first
        first = newLink; // first --> newLink
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link deleteList(int value) {
        Link current = first;
        Link previous = first;
        while (current.iData != value) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }
}

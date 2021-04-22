package com.company;

public class DoublyLinked {
    private Link first;
    private Link last;

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int value) {
        Link link = new Link(value);
        if (isEmpty())
            last = link;
        else
            first.previous = link;
        link.next = first;
        first = link;
    }

    public void insertLast(int value) {
        Link link = new Link(value);
        if (isEmpty())
            first = link;
        else {
            last.next = link;
            link.previous = last;
        }
        last = link;
    }

    public Link deleteFirst() {
        Link temp = first;
        if (first.next == null)
            last = null;
        else
            first.next.previous = null;
        first = first.next;
        return temp;
    }

    public Link deleteLast() {
        Link temp = last;
        if (first.next == null)
            first = null;
        else
            last.previous.next = null;
        last = last.previous;
        return temp;
    }

    public boolean insertAfter(int key, int value) {
        Link current = first;
        while (current.iData != key) {
            current = current.next;
            if (current == null)
                return false;
        }
        Link link = new Link(value);
        if (current == last) {
            link.next = null;
            last = link;
        } else {
            link.next = current.next;
            current.next.previous = link;
        }
        link.previous = current;
        current.next = link;
        return true;
    }

    public Link deleteKey(int key) {
        Link current = first;
        while (current.iData != key) {
            current = current.next;
            if (current.next == null)
                return null;
        }
        if (current == first)
            first = current.next;
        else
            current.previous.next = current.next;
        if (current == last)
            last = current.previous;
        else
            current.next.previous = current.previous;
        return current;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}

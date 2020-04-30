package com.company;

public class SortedList extends LinkList {

    public void insertFirst(int value) {
        Link link = new Link(value);
        Link previous = null;
        Link current = first;
        while (current != null && current.iData < value) {
            previous = current;
            current = current.next;
        }
        if (previous == null)
            first = link;
        else
            previous.next = link;
        link.next = current;
    }
}

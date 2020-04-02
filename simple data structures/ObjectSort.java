package com.company;

public class ObjectSort {
    private Person[] array;
    private int nElements;

    public ObjectSort(int max) {
        array = new Person[max];
        nElements = 0;
    }

    public void insert(String lastName, String firstName, int age) {
        array[nElements] = new Person(lastName, firstName, age);
        nElements++;
    }

    public void display() {
        for(int i = 0; i < nElements - 1; i++) {
            array[i].displayPerson();
        }
    }

    public void insertionSort() {

    }
}

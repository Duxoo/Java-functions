package com.company;

import java.util.Arrays;

public class ArraySorts {
    private int[] array;
    private int nElements;

    public ArraySorts(int max) {
        array = new int[max];
        nElements = 0;
    }

    public void insert(int value) {
        array[nElements] = value;
        nElements++;
    }

    public void show() {
        for(int i = 0; i < nElements; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }

    public void bubbleSort() {
        for(int i =  nElements - 1; i > 1; i--) {
            for(int j = 0 ; j < i; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public void selectionSort() {
        for(int i = 0; i < nElements - 1; i++) {
            int min = i;
            for(int j = i + 1; j < nElements; j++) {
                if(array[min] > array[j]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    public void insertSort() {
        for(int i = 1; i < nElements; i++) {
            int temp = array[i];
            int j = i;
            while(j != 0 && temp <= array[j - 1]) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = temp;
        }
    }
}

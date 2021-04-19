package com.company;

import java.util.Arrays;

public class ArraySorts {
    public int[] array;
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

    public void insertionSort() {
        for(int i = 1; i < nElements; i++) {
            int temp = array[i];
            int j = i;
            while(j != 0 && temp <= array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    protected int[] merge(int[] arrayA, int[] arrayB) {
        int arrayASize = arrayA.length;
        int arrayBSize = arrayB.length;
        int[] result = new int[arrayASize + arrayBSize];
        int Ai = 0;
        int Bi = 0;
        int Ci = 0;
        while (Ai < arrayASize && Bi < arrayBSize) {
            if (arrayA[Ai] < arrayB[Bi]) {
                result[Ci++] = arrayA[Ai++];
            } else {
                result[Ci++] = arrayB[Bi++];
            }
        }
        while (Ai < arrayASize) {
            result[Ci++] = arrayA[Ai++];
        }

        while (Bi < arrayBSize) {
            result[Ci++] = arrayB[Bi++];
        }
        return result;
    }

    public int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int[] result;
        int middle = array.length / 2;
        int[] left = new int[middle];
        int[] right = new int[array.length - middle];
        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = array[middle + i];
        }
        left = this.mergeSort(left);
        right = this.mergeSort(right);
        return this.array = this.merge(left, right);
    }

    public int[] shellSort(int[] array) {
        int h = 1;
        while (array.length / 3 > h) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for(int i = h; i < array.length; i++) {
                int temp = array[i];
                int j = i;
                while(j > h - 1 && temp <= array[j - h]) {
                    array[j] = array[j - h];
                    j -= h;
                }
                array[j] = temp;
            }
            h = (h - 1) / 3;
        }
        return array;
    }

    // Hoare partition scheme
    public int partition (int left, int right) {
        int leftP = left - 1;
        int rightP = right;
        int pivot = median(left, right);
        while (true) {
            while (array[++leftP] < pivot);
            while (rightP > 0 && array[--rightP] > pivot);
            if (leftP >= rightP) {
                break;
            }
            swap(leftP, rightP);
        }
        swap(leftP, right);
        return leftP;
    }

    protected int median(int left, int right) {
        int middle = (right - left) / 2;
        if (array[left] > array[middle]) {
            swap(left, middle);
        }
        if (array[left] > array[right]) {
            swap(left, right);
        }
        if (array[middle] > array[right]) {
            swap(middle, right);
        }
        return array[middle];
    }

    protected void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public void quickSort() {
        recQuickSort(0, nElements - 1);
    }

    protected void recQuickSort(int left, int right) {
        int size = right - left;
        if (size < 10) {
            insertionSortForQ(left, right);
        } else {
            int partition = partition(left, right);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    protected void insertionSortForQ(int left, int right) {
        for(int i = left + 1; i <= right; i++) {
            int temp = array[i];
            int j = i;
            while(j > left && temp <= array[j - 1]) {
                array[j] = array[j - 1];
                --j;
            }
            array[j] = temp;
        }
    }
}

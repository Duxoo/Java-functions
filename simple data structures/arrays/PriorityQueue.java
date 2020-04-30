package com.company;

import java.util.Arrays;

//priority queue with small values in the start of queue
public class PriorityQueue {
    protected int[] arr;
    protected int maxSize;
    protected int nElements;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        nElements = 0;
    }

    public void insert(int value) {
        int i;
        if(nElements == 0)
            arr[nElements++] = value;
        else {
            for(i = nElements - 1; i >= 0; i--) {
                if(value > arr[i])
                    arr[i + 1] = arr[i];
                else
                    break;
            }
            arr[i + 1] = value;
            nElements++;
        }
    }

    public void show() {
        System.out.println(Arrays.toString(arr));
    }

    public int remove() {
        return arr[--nElements];
    }

    public boolean isEmpty() {
        return nElements == 0;
    }

    public boolean isFull() {
        return nElements == maxSize;
    }
}

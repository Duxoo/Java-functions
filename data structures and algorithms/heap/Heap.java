package com.company;

public class Heap {
    protected int currentSize;
    protected Node[] heapArray;
    protected int maxSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean insert(int key) {
        if (maxSize == currentSize) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    public Node delete () {
        Node root = heapArray[0];
        heapArray[0] = heapArray[currentSize - 1];
        trickleDown(0);
        return root;
    }

    public boolean change (int index, int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);

        if (oldValue < newValue) {
            trickleUp(index);
        } else {
            trickleDown(index);
        }
        return true;
    }

    protected void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];
        while (index > 0 && bottom.getKey() > heapArray[parent].getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (index - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    protected void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];
        while (currentSize / 2 > index) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;

            if (currentSize > rightChild &&
                    heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            if (top.getKey() >= heapArray[largerChild].getKey()) {
                break;
            }

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }
}

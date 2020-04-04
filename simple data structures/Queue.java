package com.company;

import java.io.IOException;
import java.util.Arrays;

public class Queue {
    protected int rear;
    protected int front;
    protected int[] arr;
    protected int max;
    protected int nItems;

    public Queue(int max) {
        this.max = max;
        arr = new int[max];
        nItems = 0;
        rear = -1;
        front = 0;
    }

    public void inQueue(int element) throws Exception {
        try {
            if(rear == max - 1)
                rear = -1;
            arr[++rear] = element;
            nItems++;
        }
        catch (Exception error) {
            System.out.println(error.getMessage());
            throw new Exception();
        }
    }

    public int deQueue() throws Exception {
        try {
            if(front == max)
                front = 0;
            nItems--;
            return arr[front++];
        }
        catch (Exception error) {
            System.out.println(error.getMessage());
            throw new Exception();
        }
    }

    public void show() {
        System.out.println(Arrays.toString(arr));
    }

    public int peek() {
        return arr[front];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == max;
    }
}

package com.company;

import java.util.Arrays;

public class Stack {
    protected int[] arr;
    protected int max;
    protected int top;

    public Stack(int max) {
        this.max = max;
        arr = new int[max];
        top = -1;
    }

    public boolean isEmpty() {
        return arr.length > 0;
    }

    public boolean isFull() {
        return top == max - 1;
    }

    public void show() {
        System.out.println(Arrays.toString(arr));
    }

    public void push(int value) {
        if(!isFull())
            arr[++top] = value;
    }

    public int pop() {
        return arr[top--];
    }

    public int peek() {
        return arr[top];
    }
}

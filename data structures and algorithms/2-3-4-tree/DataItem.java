package com.company;

public class DataItem {
    public int data;

    public DataItem(int data) {
        this.data = data;
    }

    public int getKey() {
        return this.data;
    }

    public void display() {
        System.out.print(this.data);
    }

    public void displayItem() {
        System.out.print("/" + data);
    }
}

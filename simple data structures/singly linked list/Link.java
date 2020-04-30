package com.company;

public class Link {
    public int iData;
    public Link next;

    public Link(int iData) {
        this.iData = iData;
    }

    public void displayLink() {
        System.out.print("{" + iData + "}");
        if(next != null) {
            System.out.print("-->");
        }
    }

}

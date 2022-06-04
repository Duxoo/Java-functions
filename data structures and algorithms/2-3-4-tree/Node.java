package com.company;

/**
 * TODO: check if it's possible to remove numItems property.
 * TODO: method insertItem throws Exception out of bounce.
 */

public class Node {
    private static final int ORDER = 4;
    private int numItems;
    private Node parent;
    private Node[] childArray = new Node[ORDER];
    private DataItem[] itemArray = new DataItem[ORDER - 1];

    public void showItems() {
        for (DataItem dataItem : itemArray) {
            System.out.print(dataItem.data + " ");
        }
    }

    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    public Node disconnectChild(int childNum) {
        Node temp = childArray[childNum];
        childArray[childNum] = null;
        return temp;
    }

    public Node getChild(int childNum) {
        return childArray[childNum];
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return childArray[0] == null;
    }

    public int getNumItems() {
        return numItems;
    }

    public DataItem getItem(int index) {
        return itemArray[index];
    }

    public boolean isFull() {
        return numItems == ORDER - 1;
    }

    public int findItem(int data) {
        for (int i = 0; i < itemArray.length; i++) {
            if (itemArray[i] == null) {
                break;
            } else if (itemArray[i].data == data) {
                return i;
            }
        }
        return -1;
    }

    public int insertItem(DataItem newItem) {
        numItems++;
        int newKey = newItem.data;

        for (int i = ORDER - 2; i >= 0; i--) {
            if (itemArray[i] != null) {
                int key = itemArray[i].data;
                if (newKey < key) {
                    itemArray[i + 1] = itemArray[i];
                } else {
                    itemArray[i + 1] = newItem;
                    return i + 1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }
}

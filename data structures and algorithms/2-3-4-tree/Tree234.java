package com.company;

public class Tree234 {
    protected Node root = new Node();

    public int find(int data) {
        Node current = root;
        int childNumber;
        while (true) {
            int findItem = current.findItem(data);
            if (findItem != -1) {
                return findItem;
            } else if (current.isLeaf()) {
                return - 1;
            } else {
                current = getNextChild(current, data);
            }
        }
    }


    public Node getNextChild(Node node, int value) {
        int numItems = node.getNumItems();
        int i;
        for (i = 0; i < numItems; i++) {
            if (value < node.getItem(i).data) {
                return node.getChild(i);
            }
        }
        return node.getChild(i);
    }

    public void insert(int data) {
        Node current = root;
        DataItem newNode = new DataItem(data);
        while (true) {
            if (current.isFull()) {
                split(current);
                current = current.getParent();
                current = getNextChild(current, data);
            } else if (current.isLeaf()) {
                break;
            } else {
                current = getNextChild(current, data);
            }
        }
        current.insertItem(newNode);
    }

    public void split(Node node) {
        DataItem itemB, itemC;
        Node parent, child2, child3;
        itemC = node.removeItem();
        itemB = node.removeItem();
        child2 = node.disconnectChild(2);
        child3 = node.disconnectChild(3);
        Node newRight = new Node();
        if (node == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, node);
        }
        else {
            parent = node.getParent();
        }
        int itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();
        for (int i = n - 1; i > itemIndex; i--) {
            Node temp = parent.disconnectChild(i);
            parent.connectChild(i + 1, temp);
        }
        parent.connectChild(itemIndex+1, newRight);
        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }

    public void displayTree() {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node node, int level, int childNumber) {
        System.out.print("level=" + level + " child=" + childNumber + " ");
        node.display();
        int numItems = node.getNumItems();
        for (int i = 0; i < numItems + 1; i++) {
            Node nextNode = node.getChild(i);
            if (nextNode != null)
                recDisplayTree(nextNode, level + 1, i);
            else {
                return;
            }
        }
    }
}

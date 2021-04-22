package com.company;

public class BinarySearchTree {
    private Node root;

    public Node find (int data) {
        Node current = root;
        while (current.data != data) {
            if (current.data > data) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert (int data) {
        Node node = new Node();
        node.data = data;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (current.data > data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else if (current.data == data) {
                    return;
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete (int data) {
        Node current = root;
        Node parent = current;
        boolean leftChild = false;
        // find node and it's parent
        while (current.data != data) {
            parent = current;
            if (current.data > data) {
                leftChild = true;
                current = current.left;
            } else {
                leftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        // if node is list
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (leftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        // if node has only left child
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (leftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        // if node has only right child
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (leftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        // if node has two children
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (leftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private Node getSuccessor(Node node) {
        Node successor = node;
        Node successorParent = node;
        Node current = node.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != node.right) {
            successorParent.left = successor.right;
            successor.right = node.right;
        }
        return successor;
    }

    /**
     *
     * @param type 1 - pre-order traversal
     *             2 - in-order traversal
     *             3 - post-order traversal
     */
    public void order (int type) {
        switch (type) {
            case 1 -> preOrder(root);
            case 2 -> inOrder(root);
            case 3 -> postOrder(root);
        }
    }

    public void inOrder (Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void preOrder (Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder (Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public Node min() {
        Node current = root, last = root;
        while (current != null) {
            last = current;
            current = current.left;
        }
        return last;
    }

    public Node max() {
        Node current = root, last = root;
        while (current != null) {
            last = current;
            current = current.right;
        }
        return last;
    }
}

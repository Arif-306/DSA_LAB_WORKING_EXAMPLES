package com.mycompany.binarytree;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BST {
    Node root;

    BST() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null) return false;
        if (root.key == key) return true;

        if (key < root.key)
            return searchRec(root.left, key);
        return searchRec(root.right, key);
    }

    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            root = root.left;
            minv = root.key;
        }
        return minv;
    }

    void printPostOrder(Node node) {
        if (node == null)
            return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.key + " ");
    }

    void printInOrder(Node node) {
        if (node == null)
            return;
        printInOrder(node.left);
        System.out.print(node.key + " ");
        printInOrder(node.right);
    }

    void printPreOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    void printInOrder() {
        printInOrder(root);
    }

    void printPreOrder() {
        printPreOrder(root);
    }

    void printPostOrder() {
        printPostOrder(root);
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        BST bst = new BST();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder traversal:");
        bst.printInOrder();

        System.out.println("\n\nSearch 40: " + bst.search(40));

        bst.delete(20);
        System.out.println("Inorder traversal after deleting 20:");
        bst.printInOrder();

        System.out.println("\n\nPreorder traversal:");
        bst.printPreOrder();

        System.out.println("\n\nPostorder traversal:");
        bst.printPostOrder();
    }
}

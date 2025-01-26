

package com.mycompany.lab09_q3;



public class LAB09_Q3{
    
    static class Node{
        int key;
        Node left, right;
        public Node(int item){
            key=item;
            left=right=null;
        }
    }

    private static int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    private static void inOrderTraversal(Node node, int[] nodes, int index[]) {
        if (node == null) return;
        inOrderTraversal(node.left, nodes, index);
        nodes[index[0]] = node.key;
        index[0]++;
        inOrderTraversal(node.right, nodes, index);
    }

    private static void sortArray(int[] nodes) {
        int n = nodes.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nodes[j] > nodes[j + 1]) {
                    int temp = nodes[j];
                    nodes[j] = nodes[j + 1];
                    nodes[j + 1] = temp;
                }
            }
        }
    }

    private static void convertToBST(Node node, int[] nodes, int[] index) {
        if (node == null) return;
        convertToBST(node.left, nodes, index);
        node.key = nodes[index[0]];
        index[0]++;
        convertToBST(node.right, nodes, index);
    }

    private static void printPreorder(Node node){
        if (node == null) return;
        System.out.print(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    private static void printInorder(Node node){
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }

    private static void printPostorder(Node node){
        if (node == null) return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key + " ");
    }

    Node root;

    LAB09_Q3(int key){
        root = new Node(key);
    }
    
    LAB09_Q3(){
        root = null;
    }

    public static void main(String[] args) {
        LAB09_Q3 tree = new LAB09_Q3(); 
        tree.root = new Node(51);
        Node a = new Node(24);
        tree.root.left = a;
        Node b = new Node(3);
        tree.root.right = b;
        
        a.left = new Node(99);
        a.right = new Node(85);

        System.out.println("Original Tree:");
        System.out.println("Pre-Order");
        printPreorder(tree.root);
        System.out.println("\nPost-Order");
        printPostorder(tree.root);
        System.out.println("\nIn-Order");
        printInorder(tree.root);
        int n = countNodes(tree.root);
        int[] nodes = new int[n];
        int[] index = {0};
        inOrderTraversal(tree.root, nodes, index);
        sortArray(nodes);
        index[0] = 0;
        convertToBST(tree.root, nodes, index);
        System.out.println("\nConverted Binary Search Tree:");
        System.out.println("Pre-Order");
        printPreorder(tree.root);
        System.out.println("\nPost-Order");
        printPostorder(tree.root);
        System.out.println("\nIn-Order");
        printInorder(tree.root);
    }
}

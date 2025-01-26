

package com.mycompany.lab09;


class ExpressionTreeNode {
    String value;
    ExpressionTreeNode left, right;

    ExpressionTreeNode(String value) {
        this.value = value;
        this.left = this.right = null;
    }
}

public class LAB09 {

    public static ExpressionTreeNode constructExpressionTree() {
        
        ExpressionTreeNode node5 = new ExpressionTreeNode("5");
        ExpressionTreeNode node2A = new ExpressionTreeNode("2");
        ExpressionTreeNode node2B = new ExpressionTreeNode("2");
        ExpressionTreeNode node1 = new ExpressionTreeNode("1");
        ExpressionTreeNode node9 = new ExpressionTreeNode("9");

        ExpressionTreeNode plus1 = new ExpressionTreeNode("+");
        ExpressionTreeNode minus = new ExpressionTreeNode("-");
        ExpressionTreeNode multiply = new ExpressionTreeNode("*");
        ExpressionTreeNode plus2 = new ExpressionTreeNode("+");
        ExpressionTreeNode divide = new ExpressionTreeNode("/");

        plus1.left = node5;
        plus1.right = node2A;

        minus.left = node2B;
        minus.right = node1;

        multiply.left = plus1;
        multiply.right = minus;

        plus2.left = new ExpressionTreeNode("2");
        plus2.right = node9;

        divide.left = multiply;
        divide.right = plus2;

        return divide;
    }

    public static void printInOrder(ExpressionTreeNode root) {
        if (root == null) return;

        printInOrder(root.left);

        System.out.print(root.value + " ");

        printInOrder(root.right);
    }

    public static int evaluateExpressionTree(ExpressionTreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            return Integer.parseInt(root.value);
        }

        int leftValue = evaluateExpressionTree(root.left);
        int rightValue = evaluateExpressionTree(root.right);

        switch (root.value) {
            case "+":
                return leftValue + rightValue;
            case "-":
                return leftValue - rightValue;
            case "*":
                return leftValue * rightValue;
            case "/":
                return leftValue / rightValue;
            default:
                throw new IllegalArgumentException("Invalid operator: " + root.value);
        }
    }

    public static void main(String[] args) {
        ExpressionTreeNode root = constructExpressionTree();

        System.out.print("In-order Traversal of Expression Tree: ");
        printInOrder(root);
        System.out.println();

        int result = evaluateExpressionTree(root);
        System.out.println("Result of the Expression: " + result);
    }
}

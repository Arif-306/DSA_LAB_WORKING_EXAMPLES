
package com.mycompany.lab8;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class LAB8 {

    public static int calculateTreeLevel(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = calculateTreeLevel(root.left);
        int rightHeight = calculateTreeLevel(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        boolean end = false;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                end = true;
            } else {
                if (end) return false;
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return true;
    }

    public static boolean isFullTree(TreeNode root) {
        if (root == null) return true;
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
            return false;
        }
        return isFullTree(root.left) && isFullTree(root.right);
    }

    public static void checkTreeType(TreeNode root) {
        boolean isComplete = isCompleteTree(root);
        boolean isFull = isFullTree(root);

        if (isComplete && isFull) {
            System.out.println("The tree is both Complete and Full.");
        } else if (isComplete) {
            System.out.println("The tree is Complete.");
        } else if (isFull) {
            System.out.println("The tree is Full.");
        } else {
            System.out.println("The tree is neither Complete nor Full.");
        }
    }

    public static boolean checkChildrenSumProperty(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;

        int leftData = root.left != null ? root.left.data : 0;
        int rightData = root.right != null ? root.right.data : 0;

        if (root.data == leftData + rightData) {
            return checkChildrenSumProperty(root.left) && checkChildrenSumProperty(root.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(2);

        int level = calculateTreeLevel(root);
        System.out.println("Level of the binary tree: " + level);

        checkTreeType(root);

        boolean childrenSum = checkChildrenSumProperty(root);
        System.out.println("Does the tree satisfy the children sum property? " + (childrenSum ? "Yes" : "No"));
    }
}


package com.mycompany.lab09_q2;


public class LAB09_Q2 {

    static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null; 
        }
        return convertToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode convertToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null; 
        }

        int mid = start + (end - start) / 2; 
        TreeNode node = new TreeNode(nums[mid]);

        node.left = convertToBST(nums, start, mid - 1);
        node.right = convertToBST(nums, mid + 1, end);

        return node;
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return; 
        }
        inOrderTraversal(root.left);
        System.out.print(root.value + " "); 
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};

        TreeNode bstRoot = sortedArrayToBST(sortedArray);

        System.out.print("In-order Traversal of BST: ");
        inOrderTraversal(bstRoot);
        System.out.println();
    }
}

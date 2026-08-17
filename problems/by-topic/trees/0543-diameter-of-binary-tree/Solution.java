/**
 * Problem: Diameter of Binary Tree (Easy)
 * Link: https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Approach: post-order DFS computing height per node; diameter tracked as a side-effect
 * (leftHeight + rightHeight + 2) at each node, since the longest path may not pass through the root.
 * Time: O(n)
 * Space: O(h) recursion stack
 */
class Solution {
    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;
    }

    private int longestPath(TreeNode node) {
        if (node == null) {
            return -1; // height of a null node, so a leaf computes to 0
        }
        int leftHeight = longestPath(node.left);
        int rightHeight = longestPath(node.right);

        // path through this node: left arm + right arm + the two edges connecting them
        diameter = Math.max(diameter, leftHeight + rightHeight + 2);

        // height of this node, for the parent's calculation
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
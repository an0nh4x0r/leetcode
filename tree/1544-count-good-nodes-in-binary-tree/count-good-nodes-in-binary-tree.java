/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private int goodNodes(TreeNode root, int maxSoFar) {
        // BASE CASE
        if (root == null) return 0;

        // initialize goodNodesCount to 0;
        int goodNodesCount = 0;

        // Check if the current node is a good node
        if (root.val >= maxSoFar) {
            goodNodesCount = 1;
        }

        // Update the maximum value encountered so far
        int newMaxSoFar = Math.max(root.val, maxSoFar);

        // Recursively count good nodes in the left and right subtrees
        goodNodesCount += goodNodes(root.left, newMaxSoFar);
        goodNodesCount += goodNodes(root.right, newMaxSoFar);

        return goodNodesCount;
    }
}
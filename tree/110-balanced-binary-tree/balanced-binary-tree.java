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
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        checkHeightAndBalance(root);
        return isBalanced;
    }

    private int checkHeightAndBalance(TreeNode root) {
        // BASE CASE
        if (root == null) return 0;

        // RECURSIVE CASE
        int leftHeight = checkHeightAndBalance(root.left);
        int rightHeight = checkHeightAndBalance(root.right);

        // verify balance condition
        if (Math.abs(leftHeight - rightHeight) > 1) isBalanced = false;

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
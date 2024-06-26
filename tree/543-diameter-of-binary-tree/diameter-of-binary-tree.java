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
    
    private int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(TreeNode root) {
        // BASE CASE
        if (root == null) return 0;

        // RECURSIVE CASE
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        // MAX DIAMETER CALCULATION
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // RETURN THE HEIGHT
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
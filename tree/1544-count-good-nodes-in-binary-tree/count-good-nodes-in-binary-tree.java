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

    private int goodNodes(TreeNode root, int maximum) {
        // return 0 if the root is null
        if (root == null) return 0;
        
        // node X is named good, if in the path from root to this node X
        // there are no nodes with a value greater than X. 
        // here maximum is the max value from the root to the current node X
        int res = 0;
        if (maximum <= root.val) {
            res = 1;
        } 

        
        res += goodNodes(root.left, Math.max(root.val, maximum)); // go left and aggregate the count of good nodes
        res += goodNodes(root.right, Math.max(root.val, maximum)); // go right and aggregate the count of good nodes

        // finally return the result
        return res;
    }
}
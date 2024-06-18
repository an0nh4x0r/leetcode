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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // while recursion if we encounter null node, return false 
        // this will make sure that we don't do any further recursion on child nodes
        // and recursion call will go back to parent 
        if (root == null) return false;
        // check if the given node is equal to the subRoot
        if (isSameTree(root, subRoot)) return true;
        // we first check if the left subtree is equal to the subRoot
        // if true we have implemented OR condition so that never gets executed
        // if false we check the right node 
        // if both the result are false, we send false to parent, which will now perform similar recursion
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Recursive DFS ... documentation for this method is available in the sameTree solution
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
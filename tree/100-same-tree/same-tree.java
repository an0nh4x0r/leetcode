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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // This condition makes sure that we don't traverse further once both the nodes are null
        if (p == null && q == null) {
            return true;
        }

        // This condition makes sure that we don't traverse further deep inside the tree, once unequal nodes
        // are detected, i.e. once of the node is null or the values are not same in both nodes.
        // so we would not like to traverse further in the tree and rollback from this point.
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // This condition makes sure that at each node we are checking whether the left and right sub-tree are equal
        // or not, if both the left and right subtree are equal, recursion will make sure to send true value to the
        // parent node, otherwise it's going to return false to the parent. Once false value is sent, the parent also
        // sends the same false value to it's parent and at the end on the recursion, we get the value as false
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
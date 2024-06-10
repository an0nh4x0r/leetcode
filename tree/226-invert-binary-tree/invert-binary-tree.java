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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) deque.offerLast(node.left);
            if (node.right != null) deque.offerLast(node.right);
        }

        return root;
    }
}
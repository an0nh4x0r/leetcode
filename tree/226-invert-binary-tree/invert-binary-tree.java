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
        if (root == null) return root;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);

        while (!deque.isEmpty()) {
            var node = deque.pop();

            var temp = node.right;
            node.right = node.left;
            node.left = temp;

            if (node.right != null) deque.push(node.right);
            if (node.left != null) deque.push(node.left);
        }

        return root;
    }
}
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
    public int maxDepth(TreeNode root) {
        // if the root is null, maxDepth is 0
        if (root == null) return 0;

        // Create a double ended queue and use it as a normal queue
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        int maxDepth = 0;

        while (!deque.isEmpty()) {
            int dequeSize = deque.size();

            for (int i = 0; i < dequeSize; ++i) {
                TreeNode node = deque.pollFirst();

                if (node.left != null) {
                    deque.offerLast(node.left);
                }

                if (node.right != null) {
                    deque.offerLast(node.right);
                }
            }

            maxDepth++;
        }

        return maxDepth;
    }
}
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
        Deque<NodeRange> deque = new LinkedList<>();
        deque.offerLast(new NodeRange(root, root.val));
        int goodNodes = 0;

        while (!deque.isEmpty()) {
            NodeRange nodeRange = deque.pollFirst();
            TreeNode node = nodeRange.node();
            Integer high = nodeRange.high() > node.val ? nodeRange.high() : node.val;

            if (node != null && node.val >= high) {
                goodNodes += 1;
            }

            if (node.left != null) {
                deque.offerLast(new NodeRange(node.left, high));
            }

            if (node.right != null) {
                deque.offerLast(new NodeRange(node.right, high));
            }
        }

        return goodNodes;
    }
}

record NodeRange(TreeNode node, Integer high) {}
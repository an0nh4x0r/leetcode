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
    public boolean isValidBST(TreeNode root) {
        Deque<NodeRange> deque = new LinkedList<>();
        deque.offerLast(new NodeRange(root, null, null));

        while (!deque.isEmpty()) {
            NodeRange nodeRange = deque.pollFirst();
            TreeNode node = nodeRange.node();
            Integer low = nodeRange.low();
            Integer high = nodeRange.high();

            if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
                return false;
            }

            if (node.left != null) {
                deque.offerLast(new NodeRange(node.left, low, node.val));
            }
                        
            if (node.right != null) {
                deque.offerLast(new NodeRange(node.right, node.val, high));
            }

        }

        return true;
    }
}

record NodeRange(TreeNode node, Integer low, Integer high) {}
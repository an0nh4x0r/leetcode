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
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);

        while (!queue.isEmpty()) {
            var node = queue.pollFirst();
            if (node == null) continue;

            if(isSameTree(node, subRoot)) return true;

            queue.offerLast(node.left);
            queue.offerLast(node.right);
        }

        return false;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();

        queue1.offerLast(p);
        queue2.offerLast(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            var node1 = queue1.pollFirst();
            var node2 = queue2.pollFirst();

            if (node1 == null && node2 == null) continue;

            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }

            queue1.offerLast(node1.left);
            queue1.offerLast(node1.right);
            queue2.offerLast(node2.left);
            queue2.offerLast(node2.right);
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }
}
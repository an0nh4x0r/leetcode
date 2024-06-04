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

        // Iterating the bigger node with BFS algorithm
        while (!queue.isEmpty()) {
            var node = queue.pollFirst();

            if (isSameTree(node, subRoot)) return true;

            if (node.left != null) queue.offerLast(node.left);
            if (node.right != null) queue.offerLast(node.right);
        }

        return false;

    }

    // Comparing if the input nodes are same tree or not 
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();

        stack1.offerLast(p);
        stack2.offerLast(q);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            var node1 = stack1.pollLast();
            var node2 = stack2.pollLast();

            if (node1 == null && node2 == null) continue;

            if (node1 == null || node2 == null || node1.val != node2.val) return false;

            stack1.offerLast(node1.right);
            stack1.offerLast(node1.left);
            stack2.offerLast(node2.right);
            stack2.offerLast(node2.left);
        }

        return stack1.isEmpty() && stack2.isEmpty();
    }
}
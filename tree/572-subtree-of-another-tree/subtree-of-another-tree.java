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
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            var node = stack.pop();
            if (node == null) continue;

            if (isSameTree(node, subRoot)) return true;

            stack.push(node.right);
            stack.push(node.left);
        }

        return false;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();

        stack1.push(p);
        stack2.push(q);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            var node1 = stack1.pop();
            var node2 = stack2.pop();

            if (node1 == null && node2 == null) {
                continue;
            }

            if (node1 == null || node2 == null || node1.val != node2.val) return false;

            stack1.push(node1.right);
            stack1.push(node1.left);
            stack2.push(node2.right);
            stack2.push(node2.left);
        }

        return stack1.isEmpty() && stack2.isEmpty();
    }
}
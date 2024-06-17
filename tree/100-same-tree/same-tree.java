/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();

        stack1.push(p);
        stack2.push(q);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();

            // if both nodes ar null continue to next iteration
            if (node1 == null && node2 == null) {
                continue;
            }

            // if one of the node is null or the values are not equal, return false;
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }

            // here we are pushing right node first to the stack and then left node, so that
            // at the time of popping, we get left node first, just to imitate the recursive
            // DFS or preorder traversal
            stack1.push(node1.right);
            stack1.push(node1.left);
            stack2.push(node2.right);
            stack2.push(node2.left);
        }

        // if both the stacks are empty, trees are same; otherwise, they are not
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
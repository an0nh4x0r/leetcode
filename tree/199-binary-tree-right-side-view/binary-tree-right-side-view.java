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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> depthStack = new LinkedList<>();

        stack.offerLast(root);
        depthStack.offerLast(result.size());

        while (!stack.isEmpty()) {
            var node = stack.pollLast();
            var depth = depthStack.pollLast();

            if (result.size() == depth) {
                result.add(node.val);
            }

            if (node.left != null) {
                stack.offerLast(node.left);
                depthStack.offerLast(depth + 1);
            }
     
            if(node.right != null) {
                stack.offerLast(node.right);
                depthStack.offerLast(depth + 1);
            }
        }

        return result;
    }
}
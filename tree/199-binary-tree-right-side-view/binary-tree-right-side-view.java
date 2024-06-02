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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return List.of();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            var levelSize = queue.size();

            for (int i = 0; i < levelSize; ++i) {
                var node = queue.pollFirst();
                if (i == levelSize - 1) {
                    list.add(node.val);
                }

                if (node.left != null) {
                    queue.offerLast(node.left);
                }

                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }

        }

        return list;
    }
}
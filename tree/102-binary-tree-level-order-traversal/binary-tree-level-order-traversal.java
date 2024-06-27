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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; ++i) {
                TreeNode currentNode = deque.pollFirst();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) deque.offerLast(currentNode.left);
                if (currentNode.right != null) deque.offerLast(currentNode.right);
            }
            result.add(currentLevel);
        }

        return result;
    }
}
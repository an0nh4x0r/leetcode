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
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while (!deque.isEmpty()) {
            int dequeSize = deque.size();
            List<Integer> innerList = new ArrayList<>();
            for (int i = 0; i < dequeSize; ++i) {
                var node = deque.pollFirst();
                innerList.add(node.val);

                if (node.left != null) deque.offerLast(node.left);
                if (node.right != null) deque.offerLast(node.right);
            }
            list.add(innerList);
        }

        return list;
    }
}
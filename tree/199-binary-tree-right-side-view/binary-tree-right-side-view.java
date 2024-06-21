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
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while (!deque.isEmpty()) {
            int dequeSize = deque.size() - 1;
            
            for (int i = 0; i < dequeSize; ++i) {
                var node = deque.pollFirst();

                if (node.left != null) deque.offerLast(node.left);
                if (node.right != null) deque.offerLast(node.right);
            }

            var rightNode = deque.pollFirst();
            if (rightNode.left != null) deque.offerLast(rightNode.left);
            if (rightNode.right != null) deque.offerLast(rightNode.right);
            list.add(rightNode.val);
        }

        return list;
    }
}
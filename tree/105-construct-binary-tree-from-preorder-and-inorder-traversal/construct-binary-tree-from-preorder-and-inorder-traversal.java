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

    int preOrderIndex = 0;
    Map<Integer, Integer> inOrderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; ++i) {
            inOrderIndexMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootValue = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);

        root.left = buildTreeHelper(preorder, left, inOrderIndexMap.get(rootValue) - 1);
        root.right = buildTreeHelper(preorder, inOrderIndexMap.get(rootValue) + 1, right);

        return root;
    }


}
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

    private int preOrderIndex = 0;
    private Map<Integer, Integer> inOrderToIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // populate the map with inorder values and their indices
        for (int i = 0; i < inorder.length; ++i) {
            inOrderToIndexMap.put(inorder[i], i);
        }

        // build the tree using a helper function
        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int left, int right) {
        // BASE CASE: if there are no elements to construct the subtree
        if (left > right) return null;

        // Select the preOrderIndex element as the root and increment preOrderIndex
        int rootValue = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Build left and right subtrees recursively
        root.left = buildTreeHelper(preorder, left, inOrderToIndexMap.get(rootValue) - 1);
        root.right = buildTreeHelper(preorder, inOrderToIndexMap.get(rootValue) + 1, right);

        return root;
    }
}
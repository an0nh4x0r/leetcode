/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public static final String NULL = "X";
    public static final String DELIMITER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return NULL + DELIMITER;
        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);

        return root.val + DELIMITER + leftSerialized + rightSerialized;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodesLeftToMaterialize = new LinkedList<>();
        nodesLeftToMaterialize.addAll(Arrays.asList(data.split(DELIMITER)));
        return deserializeHelper(nodesLeftToMaterialize);
    }

    private TreeNode deserializeHelper(Queue<String> nodesLeftToMaterialize) {
        String valueForNode = nodesLeftToMaterialize.poll();

        if (valueForNode.equals(NULL)) {
            return null;
        }

        TreeNode newNode = new TreeNode(Integer.valueOf(valueForNode));
        newNode.left = deserializeHelper(nodesLeftToMaterialize);
        newNode.right = deserializeHelper(nodesLeftToMaterialize);

        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
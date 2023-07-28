package basic.algorithm.tree.serialize;

import basic.problems.tree.Serialization;
import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 12:43
 */
public class PreOrder implements Serialization {

    private int desIndex = 0;

    @Override
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, root);
        return sb.toString();
    }

    private void dfs(StringBuilder sb, TreeNode root) {
        if (sb.length() != 0) {
            sb.append(COMMA);
        }
        // 边界条件
        if (root == null) {
            sb.append(NULL);
            return;
        }
        sb.append(root.val);
        dfs(sb, root.left);
        dfs(sb, root.right);
    }

    // Decodes your encoded data to tree.
    @Override
    public TreeNode deserialize(String data) {
        return decode(data.split(COMMA));
    }

    private TreeNode decode(String[] vals) {
        String nodeVal = vals[desIndex++];
        // 边界条件
        if (nodeVal.equals(NULL)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodeVal));
        node.left = decode(vals);
        node.right = decode(vals);
        return node;
    }
}
